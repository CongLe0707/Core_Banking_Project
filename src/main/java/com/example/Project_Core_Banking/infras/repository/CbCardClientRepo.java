package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbCardClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;
@Repository
public interface CbCardClientRepo extends JpaRepository<CbCardClient, UUID> {
    Optional<CbCardClient> findByClientNo(String clientNo);

    Optional<CbCardClient> findByPassCard(String passCard);

    Optional<Object> findByIdCard(String IdCard);
}
