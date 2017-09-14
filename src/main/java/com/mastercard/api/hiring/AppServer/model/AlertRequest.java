package com.mastercard.api.hiring.AppServer.model;

/**
 * Created by e057964 on 14/9/17.
 */
public class AlertRequest {

    String code;
    Float targetRate;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getTargetRate() {
        return targetRate;
    }

    public void setTargetRate(Float targetRate) {
        this.targetRate = targetRate;
    }
}
