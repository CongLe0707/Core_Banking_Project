package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateCardClientReq;
import com.example.Project_Core_Banking.dto.response.CreateCardClientRes;
import com.example.Project_Core_Banking.dto.response.CreateClientRes;

public interface CbCreateCardClientService {

    CreateCardClientRes createCard (CommonReq<CreateCardClientReq> req);

}
