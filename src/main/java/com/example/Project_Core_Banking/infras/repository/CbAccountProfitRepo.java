package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbAccountProfit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface CbAccountProfitRepo extends JpaRepository<CbAccountProfit, UUID> {
    @Query("SELECT e FROM HdCdAccountProfit e WHERE e.channel = :channel AND e.clientNo = :clientNo AND e.acctNo = :acctNo")
    Optional<CbAccountProfit> findByChannelAndClientNoAndAcctNo(String channel, String clientNo, String acctNo);
}
