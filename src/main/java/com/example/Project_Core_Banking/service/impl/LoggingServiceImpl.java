package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.entity.CbLogApi;
import com.example.Project_Core_Banking.infras.repository.CbLogApiRepo;
import com.example.Project_Core_Banking.service.LoggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LoggingServiceImpl implements LoggingService {

    private final CbLogApiRepo cbLogApiRepo;
    @Override
    public void save(CbLogApi logApi) {
        cbLogApiRepo.save(logApi);
    }
}
