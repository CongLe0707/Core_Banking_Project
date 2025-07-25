package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbClientSubscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CbClientSubscribeRepo extends JpaRepository<CbClientSubscribe, UUID> {
    @Query("SELECT e FROM CbClientSubscribe e WHERE e.channel = :channel AND e.clientNo = :clientNo AND e.acctNo = :acctNo")
    Optional<CbClientSubscribe> findByChannelAndClientNoAndAcctNo(@Param("channel") String channel, @Param("clientNo") String clientNo, @Param("acctNo") String acctNo);
}
