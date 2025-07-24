package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.DepositReq;
import com.example.Project_Core_Banking.dto.response.DepositRes;
import com.example.Project_Core_Banking.entity.CbCardClient;
import com.example.Project_Core_Banking.entity.CbHistory;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbCardClientRepo;
import com.example.Project_Core_Banking.infras.repository.CbHistoryRepo;
import com.example.Project_Core_Banking.service.CbDepositService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
@RequiredArgsConstructor
public class CbDepositServiceImpl implements CbDepositService {
    private final CbCardClientRepo cbCardClientRepo;
    private final CbHistoryRepo historyRepo;

    @Transactional
    @Override
    public DepositRes deposi(CommonReq<DepositReq> req) {

        DepositReq data = req.getData();
        CbHistory history = new CbHistory();
        CbCardClient clien_1 = cbCardClientRepo.findByClientNo(data.clientNo())
                .orElseThrow(() -> new DelegationServiceException(
                        ResultCode.CLIENT_NOT_FOUND_1.getCode(),
                        ResultCode.CLIENT_NOT_FOUND_1.getMessage().formatted(data.clientNo())
                ));

        CbCardClient client_2 = cbCardClientRepo.findByPassCard(data.passCard())
                .orElseThrow(() -> new DelegationServiceException(
                        ResultCode.CHECK_PASS_CARD.getCode(),
                        ResultCode.CHECK_PASS_CARD.getMessage()
                ));


        if(data.amount() < 100000) {

            history.setCbCardClient(clien_1);
            history.setAmount(data.amount());
            history.setRemainingBalance(clien_1.getBalance());
            history.setTransactionType("WITHDRAW");
            history.setNote(ResultCode.MIN_AMOUNT.getMessage());
            history.setStatus("Thất bại");
            history.setTransactionTime(OffsetDateTime.now());
            historyRepo.save(history);
            throw new DelegationServiceException(
                    ResultCode.MIN_AMOUNT.getCode(),
                    ResultCode.MIN_AMOUNT.getMessage()
            );
        }

        if(clien_1.getBalance() < data.amount()) {

            history.setCbCardClient(clien_1);
            history.setAmount(data.amount());
            history.setRemainingBalance(clien_1.getBalance());
            history.setTransactionType("WITHDRAW");
            history.setNote(ResultCode.DEPO_AMOUNT.getMessage());
            history.setStatus("Thất bại");
            history.setTransactionTime(OffsetDateTime.now());
            historyRepo.save(history);
            throw new DelegationServiceException(
                    ResultCode.DEPO_AMOUNT.getCode(),
                    ResultCode.DEPO_AMOUNT.getMessage()
            );
        }
        if((clien_1.getBalance() - data.amount()) < 50000) {
            history.setCbCardClient(clien_1);
            history.setAmount(data.amount());
            history.setRemainingBalance(clien_1.getBalance());
            history.setTransactionType("WITHDRAW");
            history.setNote(ResultCode.ZERO_AMOUNT.getMessage());
            history.setStatus("Thất bại");
            history.setTransactionTime(OffsetDateTime.now());
            historyRepo.save(history);
            throw new DelegationServiceException(
                    ResultCode.ZERO_AMOUNT.getCode(),
                    ResultCode.ZERO_AMOUNT.getMessage()
            );
        }


        clien_1.setBalance(clien_1.getBalance() - data.amount());
        cbCardClientRepo.save(clien_1);
        history.setCbCardClient(clien_1);
        history.setAmount(data.amount());
        history.setRemainingBalance(clien_1.getBalance());
        history.setTransactionType("WITHDRAW");
        history.setNote(" ");
        history.setStatus("Thành Công");
        history.setTransactionTime(OffsetDateTime.now());
        historyRepo.save(history);


        return new DepositRes(
                clien_1.getClientNo(),
                clien_1.getClientName(),
                clien_1.getAmount(),
                clien_1.getBalance()
        );
    }
}


