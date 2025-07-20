package com.example.Project_Core_Banking.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseException extends RuntimeException {
    private String errCode;
    private String errMsg;

    public BaseException(String errCode, String errMsg) {
        super("%s".formatted(errMsg));
        this.errCode = errCode;
        this.errMsg = errMsg;
    }
}
