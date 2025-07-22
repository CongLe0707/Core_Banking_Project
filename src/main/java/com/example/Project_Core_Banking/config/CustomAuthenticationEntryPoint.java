package com.example.Project_Core_Banking.config;


import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException {

        CommonRes<?> commonRes = new CommonRes<>(
                ResultCode.CLIENT_NOT_FOUND.getCode(),
                ResultCode.CLIENT_NOT_FOUND.getMessage()
        );

        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(commonRes));
    }
}
