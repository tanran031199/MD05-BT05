package com.ra.advice;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    private Integer status;
    public CustomException(String msg, Integer status) {
        super(msg);
        this.status = status;
    }
}
