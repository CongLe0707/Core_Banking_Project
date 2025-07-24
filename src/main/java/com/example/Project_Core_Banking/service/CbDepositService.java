package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.DepositReq;
import com.example.Project_Core_Banking.dto.response.DepositRes;

public interface CbDepositService {

    DepositRes deposi (CommonReq<DepositReq> req);
}
