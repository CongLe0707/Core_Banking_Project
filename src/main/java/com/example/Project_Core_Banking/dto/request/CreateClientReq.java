package com.example.Project_Core_Banking.dto.request;

import java.time.OffsetDateTime;

public record CreateClientReq (
         String clientNo,
         String channel,
         String subChannel,
         String clientName,
         String clientShortName,
         String clientAddress,
         String clientNationality,
         String phone,
         String phoneNd,
         String email,
         String roleType,
         String clientType,
         String clientSegment,
         String branch,
         String partnerId,
         String globalId,
         String globalType,
         String issuePlace,
         String issueAuth,
         OffsetDateTime issueDate,
         OffsetDateTime expiredDate,
         String globalIdNd,
         String globalTypeNd,
         String issuePlaceNd,
         String issueAuthNd,
         OffsetDateTime issueDateNd,
         OffsetDateTime expiredDateNd,
         String note,
         String extendData,
         String sourceId
) {
}
