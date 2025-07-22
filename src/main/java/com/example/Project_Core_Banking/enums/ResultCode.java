package com.example.Project_Core_Banking.enums;

import lombok.Getter;

import static com.example.Project_Core_Banking.utils.Constants.UQ_CONTRACT_TYPE;


@Getter
public enum ResultCode implements IResultCode {
    SUCCESS("0000","Thành công"),
    INVALID_JSON_FORMAT("ERR01", "Json không đúng định dạng"),
    INTERNAL_SERVER_ERROR("6000","System error"),
    VALIDATION_ERROR("1002", "Validation Error"),
    CLIENT_NOT_FOUND("ERR02", "%s Đã tồn tại"),

    CLIENT_NOT_FOUND_1("ERR03","Không tìm thấy %s" );

    private String code;
    private String message;

    ResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String getCode() {
        return this.code.equals("0000") ? this.code :UQ_CONTRACT_TYPE.concat(code);
    }
}
