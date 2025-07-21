package com.example.Project_Core_Banking.entity;


import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "core_banking_client",schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbClient {
    @Id
    @GeneratedValue
    @Column(name = "client_id", nullable = false)
    private UUID clientId;

    @Column(name = "client_no", nullable = false)
    private String clientNo;

    @Column(name = "channel", nullable = false)
    private String channel;

    @Column(name = "sub_channel")
    private String subChannel;

    @Column(name = "client_name", nullable = false)
    private String clientName;

    @Column(name = "client_short_name")
    private String clientShortName;

    @Column(name = "client_address")
    private String clientAddress;

    @Column(name = "client_nationality")
    private String clientNationality;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone_nd")
    private String phoneNd;

    @Column(name = "email")
    private String email;

    @Column(name = "client_status", nullable = false)
    private String clientStatus;

    @Column(name = "trans_status")
    private String transStatus;

    @Column(name = "role_type")
    private String roleType;

    @Column(name = "client_type")
    private String clientType;

    @Column(name = "client_segment")
    private String clientSegment;

    @Column(name = "branch")
    private String branch;

    @Column(name = "partner_id")
    private String partnerId;

    @Column(name = "global_id")
    private String globalId;

    @Column(name = "global_type")
    private String globalType;

    @Column(name = "issue_place")
    private String issuePlace;

    @Column(name = "issue_auth")
    private String issueAuth;

    @Column(name = "issue_date")
    private OffsetDateTime issueDate;

    @Column(name = "expired_date")
    private OffsetDateTime expiredDate;

    @Column(name = "global_id_nd")
    private String globalIdNd;

    @Column(name = "global_type_nd")
    private String globalTypeNd;

    @Column(name = "issue_place_nd")
    private String issuePlaceNd;

    @Column(name = "issue_auth_nd")
    private String issueAuthNd;

    @Column(name = "issue_date_nd")
    private OffsetDateTime issueDateNd;

    @Column(name = "expired_date_nd")
    private OffsetDateTime expiredDateNd;

    @Column(name = "note")
    private String note;

    @Column(name = "extend_data", columnDefinition = "text")
    @Type(JsonBinaryType.class)
    private String extendData;

    @Column(name = "sys_run_date")
    private OffsetDateTime sysRunDate;

    @Column(name = "source_id")
    private String sourceId;

    @Column(name = "created_date", updatable = false)
    private OffsetDateTime createdDate;

    @Column(name = "created_by", updatable = false)
    private String createdBy;

    @Column(name = "last_modified_date")
    private OffsetDateTime lastModifiedDate;

    @Column(name = "last_modified_by")
    private String lastModifiedBy;
}
