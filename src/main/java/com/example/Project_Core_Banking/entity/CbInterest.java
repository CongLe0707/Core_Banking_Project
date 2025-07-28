package com.example.Project_Core_Banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "core_banking_interest", schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "interest_id", nullable = false)
    private UUID interestId;

    @Column(name = "term", nullable = false)
    private int term;

    @Column(name = "interest", nullable = false)
    private float interest;

}
