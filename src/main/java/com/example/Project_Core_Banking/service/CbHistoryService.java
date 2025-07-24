package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.HistoryReq;
import com.example.Project_Core_Banking.dto.response.HistoryRes;

import java.util.List;

public interface CbHistoryService {
    List<HistoryRes> history (CommonReq<HistoryReq> req);
}
