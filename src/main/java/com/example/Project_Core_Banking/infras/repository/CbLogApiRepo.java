package com.example.Project_Core_Banking.infras.repository;

import com.example.Project_Core_Banking.entity.CbLogApi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CbLogApiRepo extends JpaRepository<CbLogApi, Long> {
    Optional<CbLogApi> findTopByApiPathOrderBySeqNoDesc(String apiPath);
}
