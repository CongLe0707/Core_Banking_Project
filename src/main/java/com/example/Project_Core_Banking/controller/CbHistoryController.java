package com.example.Project_Core_Banking.controller;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.HistoryReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.service.CbHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/history/v1")
@RequiredArgsConstructor
@Slf4j
public class CbHistoryController {
    private final CbHistoryService cbHistoryService;

    @PostMapping
    public ResponseEntity<CommonRes> history (@RequestBody CommonReq<HistoryReq> req) {
        return ApiHandler.handle(req, cbHistoryService::history);
    }
}
