package com.example.Project_Core_Banking.controller;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.RegistrationReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.service.CbCreateSubscribeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/registration/v1")
@RequiredArgsConstructor
@Slf4j
public class CbAccountProfitController {

    private final CbCreateSubscribeService cbCreateSubscribeService;
    @PostMapping
    public ResponseEntity<CommonRes> createCDDelegation(@Valid @RequestBody CommonReq<RegistrationReq> req) {
        return ApiHandler.handle(req, cbCreateSubscribeService::create);
    }
}
