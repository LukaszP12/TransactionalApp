package com.example.Transactional.exception;

public class InsufficientBalanceException extends RuntimeException {

    public InsufficientBalanceException(String errMsg) {
        super(errMsg);
    }
}
