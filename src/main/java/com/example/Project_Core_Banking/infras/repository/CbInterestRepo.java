package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbInterest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CbInterestRepo extends JpaRepository<CbInterest, UUID> {
    Optional<CbInterest> findByInterestId(UUID interestId);
    Optional<CbInterest> findByTerm(int term);
}
