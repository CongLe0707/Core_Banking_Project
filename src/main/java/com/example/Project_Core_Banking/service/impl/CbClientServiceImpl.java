package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateClientReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.dto.response.CreateClientRes;
import com.example.Project_Core_Banking.entity.CbClient;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbClientRepo;
import com.example.Project_Core_Banking.mapper.CbClientMapper;
import com.example.Project_Core_Banking.service.CbClientService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CbClientServiceImpl implements CbClientService {
    private final CbClientRepo cbClientRepo;
    private final CbClientMapper cbClientMapper;

    @Transactional
    @Override
    public CreateClientRes createClient(CommonReq<CreateClientReq> req) {

        CreateClientReq data = req.getData();

        System.out.println("dasdsa " + data.clientNo());
        Optional<CbClient> existingClient = cbClientRepo.findByClientNo(data.clientNo());

        if (existingClient.isPresent()) {
            throw new DelegationServiceException(
                    ResultCode.CLIENT_NOT_FOUND.getCode(),
                    ResultCode.CLIENT_NOT_FOUND.getMessage().formatted(data.clientNo())
            );
        }

        CbClient cbClient = cbClientMapper.toEntity(req.getData());
        cbClient = cbClientRepo.save(cbClient);

        return new CreateClientRes (
            cbClient.getClientId(),
            cbClient.getClientNo(),
            cbClient.getClientName(),
            cbClient.getClientStatus(),
            cbClient.getCreatedDate(),
            cbClient.getCreatedBy()
        );
    }
}
