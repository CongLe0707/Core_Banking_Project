package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.SavingInterestReq;
import com.example.Project_Core_Banking.dto.response.SavingInterestRes;

public interface CbSavingInterestService {
    SavingInterestRes savingInterest (CommonReq<SavingInterestReq> req);
}
