package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.UpdatePassCardReq;
import com.example.Project_Core_Banking.dto.response.UpdatePassCardRes;

public interface CbUpdatePassCardService {
    UpdatePassCardRes updatePassCard (CommonReq<UpdatePassCardReq> req);
}
