package com.example.Project_Core_Banking.controller;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateClientReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.dto.response.CreateClientRes;
import com.example.Project_Core_Banking.service.CbClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create/v1")
@RequiredArgsConstructor
@Slf4j
public class CbCreateClientController {
    private final CbClientService cbClientService;

    @PostMapping
    public ResponseEntity<CommonRes> createClient (@RequestBody CommonReq<CreateClientReq> req) {
        return ApiHandler.handle(req, cbClientService::createClient);
    }
}
