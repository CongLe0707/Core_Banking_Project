package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.LoginReq;
import com.example.Project_Core_Banking.dto.response.LoginRes;

public interface CbLoginService {
    LoginRes login (CommonReq<LoginReq> req);
}
