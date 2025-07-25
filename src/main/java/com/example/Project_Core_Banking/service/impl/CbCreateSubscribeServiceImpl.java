package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.RegistrationReq;
import com.example.Project_Core_Banking.dto.response.CreateRegistrationRes;
import com.example.Project_Core_Banking.entity.CbAccountProfit;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbAccountProfitRepo;
import com.example.Project_Core_Banking.mapper.CbClientSubscribeMapper;
import com.example.Project_Core_Banking.service.CbCreateSubscribeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CbCreateSubscribeServiceImpl implements CbCreateSubscribeService {
    private final CbAccountProfitRepo  cbAccountProfitRepo;
    private final CbClientSubscribeMapper cbClientSubscribeMapper;
    @Transactional
    @Override
    public CreateRegistrationRes create(CommonReq<RegistrationReq> req) {
        RegistrationReq data = req.getData();

        if (cbAccountProfitRepo.findByChannelAndClientNoAndAcctNo(
                data.channel(),
                data.clientNo(),
                data.acctNo()
        ).isPresent()) {
            throw new DelegationServiceException(
                    ResultCode.ACCOUNT_ALREADY_REGISTERED.getCode(),
                    ResultCode.ACCOUNT_ALREADY_REGISTERED.getMessage().formatted(data.acctNo())
            );
        }
        CbAccountProfit cbAccountProfit = cbClientSubscribeMapper.toEntity(req.getData());
        cbAccountProfit = cbAccountProfitRepo.save(cbAccountProfit);


        return new CreateRegistrationRes (
                cbAccountProfit.getAcctProfitId(),
                cbAccountProfit.getProfitStatus(),
                cbAccountProfit.getClientNo(),
                cbAccountProfit.getAcctNo()
        );
    }
}
