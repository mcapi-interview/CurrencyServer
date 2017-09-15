package com.mastercard.api.hiring.AppServer.ExceptionHandler;

/**
 * Created by e057964 on 15/9/17.
 */
public class InvalidCurrencyException extends Exception {

    public InvalidCurrencyException(String currCode) {
        super(currCode);
        this.currCode = currCode;
    }

    String currCode;

    public String getCurrCode() {
        return currCode;
    }

    public void setCurrCode(String currCode) {
        this.currCode = currCode;
    }
}
