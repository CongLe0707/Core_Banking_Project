package com.example.Project_Core_Banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "Core_Bankingforex_transaction",schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbForexTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private UUID id;
    @Column(name = "fromCurrency", nullable = false)
    private String fromCurrency;
    @Column(name = "toCurrency", nullable = false)
    private String toCurrency;
    @Column(name = "originalAmount", nullable = false)
    private double originalAmount;
    @Column(name = "convertedAmount", nullable = false)
    private double convertedAmount;
    @Column(name = "rate", nullable = false)
    private double rate;
    @Column(name = "transactionTime", nullable = false)
    private LocalDateTime transactionTime;
}
