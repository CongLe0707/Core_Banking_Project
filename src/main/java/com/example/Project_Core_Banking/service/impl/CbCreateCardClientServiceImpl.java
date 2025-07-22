package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateCardClientReq;
import com.example.Project_Core_Banking.dto.response.CreateCardClientRes;
import com.example.Project_Core_Banking.entity.CbCardClient;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbCardClientRepo;
import com.example.Project_Core_Banking.infras.repository.CbClientRepo;
import com.example.Project_Core_Banking.mapper.CbCardClientMapper;
import com.example.Project_Core_Banking.service.CbCreateCardClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CbCreateCardClientServiceImpl implements CbCreateCardClientService {

    private final CbClientRepo cbClientRepo;
    private final CbCardClientRepo cbCardClientRepo;
    private final CbCardClientMapper cbCardClientMapper;
    @Transactional
    @Override
    public CreateCardClientRes createCard(CommonReq<CreateCardClientReq> req) {
        CreateCardClientReq data = req.getData();

        if (cbCardClientRepo.findByIdCard(data.idCard()).isPresent()) {
            throw new DelegationServiceException(
                    ResultCode.ID_CARD.getCode(),
                    ResultCode.ID_CARD.getMessage().formatted(data.idCard())
            );
        }

        var client = cbClientRepo.findById(data.clientId())
                .orElseThrow(() -> new DelegationServiceException(
                        ResultCode.CLIENT_NOT_FOUND.getCode(),
                        ResultCode.CLIENT_NOT_FOUND.getMessage().formatted(data.clientId())
                ));

        CbCardClient cbCardClient = cbCardClientMapper.toEntity(req.getData(),client);
        cbCardClient = cbCardClientRepo.save(cbCardClient);



        return new CreateCardClientRes (
                cbCardClient.getClientId(),
                cbCardClient.getClientNo(),
                cbCardClient.getPassCard(),
                cbCardClient.getClientName(),
                cbCardClient.getAddress(),
                cbCardClient.getEmail(),
                cbCardClient.getIdCard(),
                cbCardClient.getBalance()
        );
    }
}
