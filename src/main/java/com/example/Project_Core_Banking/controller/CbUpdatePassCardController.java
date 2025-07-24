package com.example.Project_Core_Banking.controller;


import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.UpdatePassCardReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.service.CbUpdatePassCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/update/Card/v1")
@RequiredArgsConstructor
@Slf4j
public class CbUpdatePassCardController {

    private final CbUpdatePassCardService cbUpdatePassCardService;

    @PostMapping
    public ResponseEntity<CommonRes> updatePassCard (@RequestBody CommonReq<UpdatePassCardReq> req) {
        return  ApiHandler.handle(req, cbUpdatePassCardService::updatePassCard);
    }



}
