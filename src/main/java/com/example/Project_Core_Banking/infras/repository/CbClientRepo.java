package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CbClientRepo extends JpaRepository<CbClient, UUID> {
    Optional<CbClient> findByClientNo(String clientNo);
}
