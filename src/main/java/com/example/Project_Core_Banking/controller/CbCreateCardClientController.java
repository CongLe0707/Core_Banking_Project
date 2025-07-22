package com.example.Project_Core_Banking.controller;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateCardClientReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.service.CbCreateCardClientService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card/v1")
@RequiredArgsConstructor
@Slf4j
public class CbCreateCardClientController {
    private final CbCreateCardClientService cbCreateCardClientService;
    @PostMapping
    public ResponseEntity<CommonRes> createCard(@RequestBody CommonReq<CreateCardClientReq> req) {
        return ApiHandler.handle(req,cbCreateCardClientService::createCard);
    }
}
