package com.mastercard.api.hiring.AppServer.model;

/**
 * Created by e057964 on 15/9/17.
 */
public class ErrorResponse {

    int code;
    String message;

    public ErrorResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
