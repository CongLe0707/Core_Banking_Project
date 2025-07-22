package com.example.Project_Core_Banking.entity;


import com.example.Project_Core_Banking.anotation.DatePattern;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "core_banking_card_client",schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbCardClient {

    @Id
    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @Column(name = "client_no", nullable = false)
    private String clientNo;

    @Column(name = "pass_card", nullable = false)
    private String passCard;

    @Column(name = "client_name", nullable = false)
    private  String  clientName;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "phone" , nullable = false)
    private  String phone;

    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "id_card", nullable = false)
    private String idCard;

    @Column(name = "balance", nullable = false)
    private Double balance;

    @Column(name = "time_req", nullable = false)
    @DatePattern
    private String timeReq;

    @Column(name = "amount", nullable = true)
    private Double amount;

    @Column(name = "note")
    private String note;

}
