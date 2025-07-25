package com.example.Project_Core_Banking.entity;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "core_banking_client_subscribe" ,schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbClientSubscribe {
    @Id
    @Column(name = "subscribe_id", nullable = false)
    private UUID subscribeId;

    @Column(name = "channel", nullable = false)
    private String channel;

    @Column(name = "sub_channel", nullable = false)
    private String subChannel;

    @Column(name = "client_no")
    private String clientNo;

    @Column(name = "acct_no")
    private String acctNo;

    @Column(name = "subscribe_date")
    private OffsetDateTime subscribeDate;

    @Column(name = "subscribe_type")
    private String subscribeType;

    @Column(name = "subscribe_data", columnDefinition = "jsonb")
    @Type(JsonBinaryType.class)
    private String subscribeData;

    @Column(name = "status_process")
    private String statusProcess;

    @Column(name = "status_dc")
    private String statusDc;

    @Column(name = "status_account_profit")
    private String statusAccountProfit;

    @Column(name = "status_contract")
    private String statusContract;

    @Column(name = "status_ott")
    private String statusOtt;

    @Column(name = "request_id")
    private String requestId;

    @Column(name = "user_channel")
    private String userChannel;

    @Column(name = "account_profit_id")
    private UUID accountProfitId;

    @Column(name = "trans_no")
    private String transNo;

    @CreationTimestamp
    @Column(name = "created_date", columnDefinition = "timestamptz")
    private OffsetDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_ws_id")
    private String createdWsId;
}
