package com.example.Project_Core_Banking.service.impl;

import com.example.Project_Core_Banking.config.ExchangeRateClient;
import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.ForexConvertReq;
import com.example.Project_Core_Banking.dto.response.ForexConvertRes;
import com.example.Project_Core_Banking.entity.CbForexTransaction;
import com.example.Project_Core_Banking.infras.repository.CbForexTransactionRepository;
import com.example.Project_Core_Banking.service.CbForexConvertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ForexConvertServiceImpl implements CbForexConvertService {

    private final CbForexTransactionRepository cbForexTransactionRepository;
    private final ExchangeRateClient exchangeRateClient;
    @Override
    public ForexConvertRes convert(CommonReq<ForexConvertReq> req) {
        ForexConvertReq data = req.getData();
        double rate = exchangeRateClient.getRate(
                data.fromCurrency().toUpperCase(),
                data.toCurrency().toUpperCase()
        );

        double convertedAmount = data.amount() * rate;

        CbForexTransaction transaction = new CbForexTransaction(
                null,
                data.fromCurrency().toUpperCase(),
                data.toCurrency().toUpperCase(),
                data.amount(),
                convertedAmount,
                rate,
                LocalDateTime.now()
        );

        cbForexTransactionRepository.save(transaction);

        return new ForexConvertRes(
                data.amount(),
                convertedAmount,
                rate,
                data.fromCurrency(),
                data.toCurrency(),
                transaction.getTransactionTime()
        );
    }
}
