package com.example.Project_Core_Banking.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "core_banking_account_profit" ,schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbAccountProfit {
    @Id
    @Column(name = "acct_profit_id", nullable = false)
    private UUID acctProfitId;

    @Column(name = "channel", nullable = false)
    private String channel;

    @Column(name = "sub_channel", nullable = false)
    private String subChannel;

    @Column(name = "acct_profit_no", nullable = false)
    private String acctProfitNo;

    @Column(name = "client_no", nullable = false)
    private String clientNo;

    @Column(name = "acct_no", nullable = false)
    private String acctNo;

    @Column(name = "acct_name", nullable = false)
    private String acctName;

    @Column(name = "global_id", nullable = false)
    private String globalId;

    @Column(name = "effect_date", nullable = false)
    private OffsetDateTime effectDate;

    @Column(name = "profit_status", nullable = false)
    private String profitStatus;

    @Column(name = "contract_status", nullable = false)
    private String contractStatus;

    @Column(name = "close_profit_date")
    private OffsetDateTime closeProfitDate;

    @Column(name = "investment_amt", nullable = false)
    private BigDecimal investmentAmt;

    @Column(name = "accrued_interest_amt", nullable = false)
    private BigDecimal accruedInterestAmt;

    @Column(name = "pledged_amt", nullable = false)
    private BigDecimal pledgedAmt;

    @Column(name = "available_amt", nullable = false)
    private BigDecimal availableAmt;

    @Column(name = "paid_interest_amt", nullable = false)
    private BigDecimal paidInterestAmt;

    @Column(name = "branch", length = 10)
    private String branch;

    @Column(name = "officer_id", length = 30)
    private String officerId;

    @Column(name = "refernal_code", length = 50)
    private String refernalCode;

    @Column(name = "flag_limit_cust", nullable = false)
    private String flagLimitCust;

    @Column(name = "cust_min_value", nullable = false)
    private BigDecimal custMinValue;

    @Column(name = "cust_min_percent", nullable = false)
    private BigDecimal custMinPercent;

    @Column(name = "version_app")
    private String versionApp;

    @CreationTimestamp
    @Column(name = "created_date")
    private OffsetDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private OffsetDateTime lastModifiedDate;

    @Column(name = "last_run_date")
    private OffsetDateTime lastRunDate;

    @Column(name = "last_trans_date")
    private OffsetDateTime lastTransDate;

    @Column(name = "last_bal_update")
    private OffsetDateTime lastBalUpdate;

    @Column(name = "last_limit_date")
    private OffsetDateTime lastLimitDate;
}
