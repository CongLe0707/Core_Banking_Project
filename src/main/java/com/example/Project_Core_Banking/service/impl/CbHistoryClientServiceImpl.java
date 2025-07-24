package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.entity.CbHistory;
import com.example.Project_Core_Banking.infras.repository.CbHistoryRepo;
import com.example.Project_Core_Banking.service.CbHistoryClientService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CbHistoryClientServiceImpl implements CbHistoryClientService {
    private final CbHistoryRepo cbHistoryRepo;

    @Override
    public void save(CbHistory cbHistory) {
        cbHistoryRepo.save(cbHistory);
    }
}
