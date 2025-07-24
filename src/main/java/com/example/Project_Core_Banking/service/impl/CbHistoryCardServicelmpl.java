package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.HistoryReq;
import com.example.Project_Core_Banking.dto.response.HistoryRes;
import com.example.Project_Core_Banking.entity.CbCardClient;
import com.example.Project_Core_Banking.entity.CbHistory;
import com.example.Project_Core_Banking.enums.ResultCode;
import com.example.Project_Core_Banking.exception.DelegationServiceException;
import com.example.Project_Core_Banking.infras.repository.CbHistoryRepo;
import com.example.Project_Core_Banking.mapper.CbHistoryMapper;
import com.example.Project_Core_Banking.service.CbHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class CbHistoryCardServicelmpl implements CbHistoryService {
    private final CbHistoryRepo cbHistoryRepo;
    private final CbHistoryMapper cbHistoryMapper;
    @Override
    public List<HistoryRes> history(CommonReq<HistoryReq> req) {
        HistoryReq data = req.getData();
        validRequest(data);

        List<CbHistory> historyEntities = cbHistoryRepo.findAllByClientId(req.getData().clientId());
        if (historyEntities.isEmpty()) {
            throw new DelegationServiceException(
                    ResultCode.NO_CLIENT_ID.getCode(),
                    ResultCode.NO_CLIENT_ID.getMessage().formatted(data.clientId())
            );
        }

        return historyEntities.stream()
                .map(cbHistoryMapper::toDto)
                .toList();
    }
    private void validRequest(HistoryReq data){
        if(Objects.isNull(data.clientId())){
            throw new DelegationServiceException(
                    ResultCode.NOT_NULL.getCode(),
                    ResultCode.NOT_NULL.getMessage()
            );
        }
    }
}
