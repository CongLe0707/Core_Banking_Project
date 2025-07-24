package com.example.Project_Core_Banking.controller;

import com.example.Project_Core_Banking.dto.request.CommonReq;
import com.example.Project_Core_Banking.dto.request.UpdatePassCardReq;
import com.example.Project_Core_Banking.dto.response.CommonRes;
import com.example.Project_Core_Banking.utils.Utils;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;


import java.util.function.Function;

@UtilityClass
@Slf4j
public class ApiHandler {
    public <RQ, RS> ResponseEntity<CommonRes> handle(CommonReq<RQ> req, Function<CommonReq<RQ>, RS> function) {
        log.info("API request: {}", Utils.object2Json(req));
        var rsData = function.apply(req);
        var commonRes = new CommonRes<>(rsData);
        log.info("API response: {}", Utils.object2Json(commonRes));
        return ResponseEntity.ok(commonRes);
    }

    public ResponseEntity<CommonRes<?>> badRequest(CommonRes<?> commonRes) {
        log.info("Error response: {}", Utils.object2Json(commonRes));
        return ResponseEntity.ok(commonRes);
    }

    public ResponseEntity<CommonRes<?>> badRequest(String errorCode, String errorMsg) {
        CommonRes<?> commonRes = new CommonRes<>(errorCode, errorMsg);
        log.info("Error response: {}", Utils.object2Json(commonRes));
        return ResponseEntity.ok(commonRes);
    }



}
