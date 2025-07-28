package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.UpdateInterestReq;
import com.example.Project_Core_Banking.dto.response.CreateInterestRes;

public interface CbUpdateInterestService {

    CreateInterestRes updateInterest(CommonReq<UpdateInterestReq> req);
}
