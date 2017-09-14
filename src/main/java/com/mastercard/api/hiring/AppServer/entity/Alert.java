package com.mastercard.api.hiring.AppServer.entity;

import javax.persistence.*;

/**
 * Created by e057964 on 14/9/17.
 */
@Entity
public class Alert {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "currency_id")
    private Currency currency;

    private Float targetRate;

    public Alert() {
    }

    public Alert(Currency currency, Float targetRate) {
        this.currency = currency;
        this.targetRate = targetRate;
    }
}
