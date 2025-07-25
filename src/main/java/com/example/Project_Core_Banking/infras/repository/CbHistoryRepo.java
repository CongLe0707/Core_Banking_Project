package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CbHistoryRepo extends JpaRepository<CbHistory, UUID> {
    List<CbHistory> findAllByCbCardClient_ClientId(UUID clientId);

}
