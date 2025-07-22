package com.example.Project_Core_Banking.filter;

import com.example.Project_Core_Banking.config.JwtTokenUtil;
import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.entity.CbLogApi;
import com.example.Project_Core_Banking.service.LoggingService;
import com.fasterxml.jackson.core.type.TypeReference;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.ContentCachingResponseWrapper;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Component
public class TrackingRequestFilter extends OncePerRequestFilter {
    private final ObjectMapper objectMapper;
    private final LoggingService loggingService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,

                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        if (isHealthCheckRequest(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        CachedHttpServletRequest requestWrapper = new CachedHttpServletRequest(request);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper(response);

        String payload = IOUtils.toString(requestWrapper.getInputStream(), request.getCharacterEncoding());
        String authHeader = request.getHeader("Authorization");

        // Có JWT → kiểm tra, không hợp lệ thì không set SecurityContext
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            try {
                if (jwtTokenUtil.validateToken(token)) {
                    Claims claims = jwtTokenUtil.getClaims(token);
                    String clientNo = claims.getSubject();
                    String role = claims.get("role", String.class);

                    if (clientNo != null && role != null) {
                        UsernamePasswordAuthenticationToken authentication =
                                new UsernamePasswordAuthenticationToken(
                                        clientNo, null,
                                        Collections.singletonList(new SimpleGrantedAuthority(role))
                                );
                        SecurityContextHolder.getContext().setAuthentication(authentication);

                    }
                }
            } catch (Exception e) {
                log.warn("JWT invalid, proceeding unauthenticated: {}", e.getMessage());
            }
        }

        // Luôn luôn cho qua controller
        executeFilter(payload, requestWrapper, responseWrapper, filterChain);
    }


    private boolean isHealthCheckRequest(HttpServletRequest request) {
        String uri = request.getRequestURI();
        return "/actuator/health/liveness".equals(uri) || "/actuator/health/readiness".equals(uri);
    }

    @SneakyThrows
    private void executeFilter(String payload,
                               CachedHttpServletRequest request,
                               ContentCachingResponseWrapper responseWrapper,
                               FilterChain filterChain) {

        OffsetDateTime requestTime = OffsetDateTime.now();
        Exception exception = null;

        try {
            filterChain.doFilter(request, responseWrapper);
        } catch (Exception ex) {
            exception = ex;
            throw ex;
        } finally {
            try {
                CbLogApi logApi = new CbLogApi();
                logApi.setApiPath(request.getRequestURL().toString());
                logApi.setType(request.getMethod());
                logApi.setReqQuery(request.getQueryString());
                logApi.setReqTime(requestTime);
                logApi.setRespTime(OffsetDateTime.now());
                logApi.setCreatedDate(OffsetDateTime.now());

                Map<String, String> headers = Collections.list(request.getHeaderNames())
                        .stream()
                        .collect(Collectors.toMap(h -> h, request::getHeader, (a, b) -> b));

                logApi.setReqHeader(objectMapper.writeValueAsString(headers));

                String cleanedPayload = payload.replaceAll("\\s*[\r\n]+\\s*", " ").trim();
                logApi.setReqBody(cleanedPayload.isEmpty() ? null : cleanedPayload);

                String responseBody = new String(responseWrapper.getContentAsByteArray());
                logApi.setRespData(responseBody.isEmpty() ? null : responseBody);
                try {
                    if (!payload.isEmpty()) {
                        CommonReq<Object> commonReq = objectMapper.readValue(payload, new TypeReference<>() {});
                        logApi.setReqId(commonReq.getRequestId());
                        logApi.setReqChannel(commonReq.getChannel());
                    }
                } catch (Exception e) {
                    log.warn("Could not parse request body to get requestId/channel", e);
                }

                logApi.setLevel(determineLogLevel(responseWrapper, exception));

                loggingService.save(logApi);
            } catch (Exception e) {
                log.error("Failed to save API log", e);
            } finally {
                responseWrapper.copyBodyToResponse();
            }
        }
    }

    private String determineLogLevel(HttpServletResponse response, Exception ex) {
        try {
            byte[] responseArray = ((ContentCachingResponseWrapper) response).getContentAsByteArray();
            String responseBody = new String(responseArray).trim();

            if (!responseBody.isEmpty()) {
                JsonNode rootNode = objectMapper.readTree(responseBody);
                String status = rootNode.path("resultStatus").asText();
                return switch (status) {
                    case "0000" -> "INFO";
                    case "6000" -> "ERROR";
                    default -> "WARNING";
                };
            }
            return "WARNING";
        } catch (Exception e) {
            log.warn("Could not determine log level from response body", e);
            return "ERROR";
        }
    }


}