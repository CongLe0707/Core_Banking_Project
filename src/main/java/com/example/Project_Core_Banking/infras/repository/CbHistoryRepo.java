package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CbHistoryRepo extends JpaRepository<CbHistory, UUID> {
    List<CbHistory> findAllByClientId(UUID clientId);
}
