package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.config.JwtTokenUtil;
import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.LoginReq;
import com.example.Project_Core_Banking.dto.response.LoginRes;
import com.example.Project_Core_Banking.entity.CbClient;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbClientRepo;
import com.example.Project_Core_Banking.service.CbLoginService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CbLoginServiceImpl implements CbLoginService {
    private final CbClientRepo cbClientRepo;
    private final JwtTokenUtil jwtTokenUtil;
    @Transactional
    @Override
    public LoginRes login(CommonReq<LoginReq> req) {


        LoginReq data = req.getData();

        System.out.println("sadasd" + data);
        CbClient client = cbClientRepo.findByClientNo(data.clientNo())
                .orElseThrow(() -> new DelegationServiceException(
                    ResultCode.CLIENT_NOT_FOUND_1.getCode(),
                    ResultCode.CLIENT_NOT_FOUND_1.getMessage().formatted(data.clientNo())
        ));
        return new LoginRes(
                jwtTokenUtil.generateAccessToken(client.getClientNo(), client.getRoleType())
                , jwtTokenUtil.generateRefreshToken(client.getClientNo(), client.getRoleType()));
    }
}
