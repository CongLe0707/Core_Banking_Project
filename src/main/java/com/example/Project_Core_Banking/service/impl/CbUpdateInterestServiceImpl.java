package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.UpdateInterestReq;
import com.example.Project_Core_Banking.dto.response.CreateInterestRes;
import com.example.Project_Core_Banking.entity.CbInterest;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbInterestRepo;
import com.example.Project_Core_Banking.service.CbUpdateInterestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CbUpdateInterestServiceImpl implements CbUpdateInterestService {
    private final CbInterestRepo cbInterestRepo;
    @Transactional
    @Override
    public CreateInterestRes updateInterest(CommonReq<UpdateInterestReq> req) {
        UpdateInterestReq updateInterestReq = req.getData();

        CbInterest cbInterest = cbInterestRepo.findByInterestId(updateInterestReq.interestId())
                .orElseThrow( () -> new DelegationServiceException(
                    ResultCode.NO_INTEREST_ID.getCode(),
                    ResultCode.NO_INTEREST_ID.getMessage()
        ));

        cbInterest.setTerm(updateInterestReq.term());
        cbInterest.setInterest(updateInterestReq.interest());
        cbInterestRepo.save(cbInterest);

        return new  CreateInterestRes (
                cbInterest.getInterestId(),
                cbInterest.getTerm(),
                cbInterest.getInterest()
        );
    }
}
