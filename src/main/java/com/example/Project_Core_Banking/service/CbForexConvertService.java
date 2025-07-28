package com.example.Project_Core_Banking.service;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.ForexConvertReq;
import com.example.Project_Core_Banking.dto.response.ForexConvertRes;

public interface CbForexConvertService {
    ForexConvertRes convert(CommonReq<ForexConvertReq> req);
}
