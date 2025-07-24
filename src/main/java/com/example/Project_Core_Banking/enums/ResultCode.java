package com.example.Project_Core_Banking.enums;

import lombok.Getter;

import static com.example.Project_Core_Banking.utils.Constants.UQ_CONTRACT_TYPE;


@Getter
public enum ResultCode implements IResultCode {
    SUCCESS("0000","Thành công"),
    INVALID_JSON_FORMAT("ERR01", "Json không đúng định dạng"),
    INTERNAL_SERVER_ERROR("6000","System error"),
    VALIDATION_ERROR("1002", "Validation Error"),
    CLIENT_NOT_FOUND("ERR02", " Đã tồn tại %s"),

    CLIENT_NOT_FOUND_1("ERR03","Không tìm thấy %s" ),
    ID_CARD("ERR04","CCCD đã được sử dụng"),
    PASS_CARD("ERR05", "Bạn nhập sai mật khẩu" ),
    NEW_PASS_CARD("ERR06","Mật khẩu mới phải khác với mật khẩu cũ" ),
    MIN_AMOUNT("ERR07","Số tiền rút không dược bé hơn 100k" ),
    DEPO_AMOUNT("ERR08","Số tiền bạn rút không được vượt quá số tiền trong tài khoản"),
    ZERO_AMOUNT("ERR09","Số tiền không đủ" ),
    CHECK_PASS_CARD("ERR10", "Bạn nhập sai pass" );

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
