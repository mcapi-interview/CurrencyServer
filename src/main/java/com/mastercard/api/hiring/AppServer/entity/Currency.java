package com.mastercard.api.hiring.AppServer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by e057964 on 14/9/17.
 */

@Entity
public class Currency {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;


    private String code;
    private String country;
    private String name;
    private String flagPath;
    private Float rate;

    public String getFlagPath() {
        return flagPath;
    }

    public void setFlagPath(String flagPath) {
        this.flagPath = flagPath;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Float getRate() {
        return rate;
    }

    public void setRate(Float rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return String.format(
                "Currency[id=%d, code='%s', country='%s']",
                id, code, country);
    }
}
