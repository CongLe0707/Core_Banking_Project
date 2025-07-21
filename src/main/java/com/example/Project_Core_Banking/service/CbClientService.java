package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateClientReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.dto.response.CreateClientRes;

public interface CbClientService {
    CreateClientRes createClient (CommonReq<CreateClientReq> req);
}
