package com.example.Project_Core_Banking.controller;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.DepositReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.service.CbDepositService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deposit/v1")
@RequiredArgsConstructor
@Slf4j
public class CbDepositController {
    private final CbDepositService cbDepositService;

    @PostMapping
    public ResponseEntity<CommonRes> deposit (@RequestBody CommonReq<DepositReq> req) {
        return ApiHandler.handle(req, cbDepositService::deposi);
    }
}
