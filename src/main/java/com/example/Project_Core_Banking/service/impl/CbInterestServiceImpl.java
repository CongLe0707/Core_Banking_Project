package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.CreateInterestReq;
import com.example.Project_Core_Banking.dto.response.CreateInterestRes;
import com.example.Project_Core_Banking.entity.CbInterest;
import com.example.Project_Core_Banking.infras.repository.CbInterestRepo;
import com.example.Project_Core_Banking.mapper.CbInterestMapper;
import com.example.Project_Core_Banking.service.CbInterestService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CbInterestServiceImpl implements CbInterestService {
    private final CbInterestMapper cbInterestMapper;
    private final CbInterestRepo cbInterestRepo;


    @Transactional
    @Override
    public CreateInterestRes createInterest(CommonReq<CreateInterestReq> req) {
        CreateInterestReq data = req.getData();

        CbInterest cbInterest =  cbInterestMapper.toEntity(data);
        cbInterest = cbInterestRepo.save(cbInterest);

        return new CreateInterestRes (
                cbInterest.getInterestId(),
                cbInterest.getTerm(),
                cbInterest.getInterest()
        ) ;
    }
}
