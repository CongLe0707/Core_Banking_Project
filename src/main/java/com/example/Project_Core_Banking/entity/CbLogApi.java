package com.example.Project_Core_Banking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Entity
@Table(name = "core_banking_log_api",schema = "core_banking")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CbLogApi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seq_no")
    private  Long seqNo;

    @Column(name = "api_path", columnDefinition = "text")
    private String apiPath;

    @Column(name = "type")
    private String type;

    @Column(name = "step")
    private String step;

    @Column(name = "sub_step")
    private String subStep;

    @Column(name = "level")
    private String level;

    @Column(name = "req_id")
    private String reqId;

    @Column(name = "req_channel")
    private String reqChannel;

    @Column(name = "req_subchannel")
    private String reqSubchannel;

    @Column(name = "req_header", columnDefinition = "text")
    private String reqHeader;

    @Column(name = "req_body", columnDefinition = "text")
    private String reqBody;

    @Column(name = "req_query", columnDefinition = "text")
    private String reqQuery;

    @Column(name = "req_time")
    private OffsetDateTime reqTime;

    @Column(name = "req_user")
    private String reqUser;

    @Column(name = "req_ip")
    private String reqIp;

    @Column(name = "resp_data", columnDefinition = "text")
    private String respData;

    @Column(name = "resp_time")
    private OffsetDateTime respTime;

    @Column(name = "created_date")
    private OffsetDateTime createdDate;

    @Column(name = "created_by")
    private String createdBy;
}
