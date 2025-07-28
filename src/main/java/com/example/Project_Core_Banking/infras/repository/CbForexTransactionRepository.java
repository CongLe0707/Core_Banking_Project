package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbForexTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CbForexTransactionRepository extends JpaRepository<CbForexTransaction, UUID> {
}
