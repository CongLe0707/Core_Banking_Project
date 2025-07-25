package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.RegistrationReq;
import com.example.Project_Core_Banking.dto.response.CreateRegistrationRes;

public interface CbCreateSubscribeService {
    CreateRegistrationRes create (CommonReq<RegistrationReq> req);
}
