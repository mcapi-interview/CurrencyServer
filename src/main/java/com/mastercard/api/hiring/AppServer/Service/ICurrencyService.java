package com.mastercard.api.hiring.AppServer.Service;

import com.mastercard.api.hiring.AppServer.entity.Currency;

import java.util.List;

/**
 * Created by e057964 on 14/9/17.
 */
public interface ICurrencyService {

    List<Currency> getAllCurrencies();

    Currency getCurrencyByCode(String code);
}
