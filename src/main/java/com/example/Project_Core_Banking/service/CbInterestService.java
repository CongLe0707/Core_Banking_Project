package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateInterestReq;
import com.example.Project_Core_Banking.dto.response.CreateInterestRes;

public interface CbInterestService {
    CreateInterestRes createInterest(CommonReq<CreateInterestReq> req);
}
