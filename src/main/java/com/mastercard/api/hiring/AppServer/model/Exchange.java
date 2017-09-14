package com.mastercard.api.hiring.AppServer.model;

/**
 * Created by e057964 on 14/9/17.
 */
public class Exchange {

    String baseCode;
    String targetCode;
    Float rate;

    public String getBaseCode() {
        return baseCode;
    }

    public void setBaseCode(String baseCode) {
        this.baseCode = baseCode;
    }

    public String getTargetCode() {
        return targetCode;
    }

    public void setTargetCode(String targetCode) {
        this.targetCode = targetCode;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }
}
