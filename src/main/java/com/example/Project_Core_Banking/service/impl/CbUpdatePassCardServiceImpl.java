package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.UpdatePassCardReq;
import com.example.Project_Core_Banking.dto.response.UpdatePassCardRes;
import com.example.Project_Core_Banking.entity.CbCardClient;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbCardClientRepo;
import com.example.Project_Core_Banking.service.CbUpdatePassCardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CbUpdatePassCardServiceImpl implements CbUpdatePassCardService {
    private final CbCardClientRepo cbCardClientRepo;

    @Transactional
    @Override
    public UpdatePassCardRes updatePassCard(CommonReq<UpdatePassCardReq> req) {
        UpdatePassCardReq data = req.getData();

        CbCardClient client = cbCardClientRepo.findByClientNo(data.clientNo())
                .orElseThrow(() -> new DelegationServiceException(
                    ResultCode.CLIENT_NOT_FOUND_1.getCode(),
                    ResultCode.CLIENT_NOT_FOUND_1.getMessage().formatted(data.clientNo())
        ));

        
        if (!cbCardClientRepo.findByPassCard(data.passCard()).isPresent()) {
            throw new DelegationServiceException(
                    ResultCode.PASS_CARD.getCode(),
                    ResultCode.PASS_CARD.getMessage());
        }

        if (Objects.equals(data.passCard(), data.newPassCard())) {
            throw  new  DelegationServiceException(
                    ResultCode.NEW_PASS_CARD.getCode(),
                    ResultCode.NEW_PASS_CARD.getMessage());
        }

        client.setPassCard(data.newPassCard());
        cbCardClientRepo.save(client);

        return new  UpdatePassCardRes (
                client.getClientNo(),
                client.getPassCard()
        );
    }
}
