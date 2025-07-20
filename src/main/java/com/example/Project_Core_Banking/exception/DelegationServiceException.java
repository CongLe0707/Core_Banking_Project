package com.example.Project_Core_Banking.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DelegationServiceException extends BaseException{
    public DelegationServiceException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }
}
