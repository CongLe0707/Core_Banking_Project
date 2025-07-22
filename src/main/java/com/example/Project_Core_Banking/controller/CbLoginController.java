package com.example.Project_Core_Banking.controller;


import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.LoginReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.service.CbClientService;
import com.example.Project_Core_Banking.service.CbLoginService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login/v1")
@RequiredArgsConstructor
@Slf4j
public class CbLoginController {
    private final CbLoginService cbLoginService;


    @PostMapping
    public ResponseEntity<CommonRes> login (@RequestBody CommonReq<LoginReq> req) {
        return ApiHandler.handle(req, cbLoginService::login);
    }
}
