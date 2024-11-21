package com.example.Transactional.exception;

public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String errMsg) {
        super(errMsg);
    }
}
