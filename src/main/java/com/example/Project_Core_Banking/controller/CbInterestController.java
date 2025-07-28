package com.example.Project_Core_Banking.controller;


import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateInterestReq;
import com.example.Project_Core_Banking.dto.request.SavingInterestReq;
import com.example.Project_Core_Banking.dto.request.UpdateInterestReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.dto.response.SavingInterestRes;
import com.example.Project_Core_Banking.service.CbInterestService;
import com.example.Project_Core_Banking.service.CbSavingInterestService;
import com.example.Project_Core_Banking.service.CbUpdateInterestService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/interest")
@RequiredArgsConstructor
@Slf4j
public class CbInterestController {

    private final CbInterestService cbInterestService;
    private final CbUpdateInterestService cbUpdateInterestService;
    private final CbSavingInterestService cbSavingInterestService;

    @PostMapping("/create/v1")
    public ResponseEntity<CommonRes> createInterest (@RequestBody CommonReq<CreateInterestReq> req) {
        return ApiHandler.handle(req,cbInterestService::createInterest );
    }

    @PostMapping("/update/v1")
    public ResponseEntity<CommonRes> updateInterest (@RequestBody CommonReq<UpdateInterestReq> req) {
        return ApiHandler.handle(req,cbUpdateInterestService::updateInterest);
    }

    @PostMapping("/saving/v1")
    public ResponseEntity<CommonRes> savingInterest (@RequestBody CommonReq<SavingInterestReq> req) {
        return ApiHandler.handle(req,cbSavingInterestService::savingInterest);
    }
}
