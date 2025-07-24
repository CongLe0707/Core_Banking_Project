package com.example.Project_Core_Banking.entity;

import com.example.Project_Core_Banking.anotation.DatePattern;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "core_banking_history", schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "history_id", nullable = false)
    private UUID historyId;

    @ManyToOne
    @JoinColumn(name = "client_id", referencedColumnName = "client_id", nullable = false)
    private CbCardClient cbCardClient;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "remaining_balance", nullable = false)
    private Double remainingBalance;

    @Column(name = "transaction_type", nullable = false)
    private String transactionType;

    @Column(name = "note")
    private String note;

    @Column(name = "status")
    private String status;

    @Column(name = "transaction_time", nullable = false)
    @DatePattern
    private OffsetDateTime transactionTime;
}
