package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.SavingInterestReq;
import com.example.Project_Core_Banking.dto.response.SavingInterestRes;
import com.example.Project_Core_Banking.entity.CbInterest;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbInterestRepo;
import com.example.Project_Core_Banking.service.CbSavingInterestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class CbSavingInterestServiceImpl implements CbSavingInterestService {
    private final CbInterestRepo cbInterestRepo;
    @Override
    public SavingInterestRes savingInterest(CommonReq<SavingInterestReq> req) {
        SavingInterestReq savingInterestReq = req.getData();
        CbInterest cbInterest = cbInterestRepo.findByTerm(savingInterestReq.term())
                .orElseThrow(() -> new DelegationServiceException(
                    ResultCode.NO_TERM.getCode(),
                    ResultCode.NO_TERM.getMessage()
        ));
        double principal = savingInterestReq.principalAmount();
        float interestRate = cbInterest.getInterest(); // từ DB
        int term = savingInterestReq.term() ;
        LocalDate startDate = savingInterestReq.startDate();

        // 2. Tính toán lãi
        double interestAmount = principal * (interestRate / 100.0) * (term / 12.0);
        double totalAmount = principal + interestAmount;
        LocalDate maturityDate = startDate.plusMonths(term);


        return new SavingInterestRes (
                principal,
                interestAmount,
                totalAmount,
                maturityDate,
                interestRate,
                term
        ) ;
    }
}
