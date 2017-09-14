package com.mastercard.api.hiring.AppServer.Service;

import com.mastercard.api.hiring.AppServer.dao.ICurrencyDao;
import com.mastercard.api.hiring.AppServer.entity.Currency;
import com.mastercard.api.hiring.AppServer.model.Exchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by e057964 on 14/9/17.
 */
@Service
public class CurrencyService implements  ICurrencyService{

    @Autowired
    ICurrencyDao currencyRepo;

    @Override
    public List<Currency> getAllCurrencies() {

        List<Currency> currencies = new ArrayList<>();
        for(Currency currency: currencyRepo.findAll()){

            currencies.add(currency);
        }

        return currencies.stream().sorted(Comparator.comparing(Currency::getCode)).collect(Collectors.toList());
    }

    @Override
    public Currency getCurrencyByCode(String code) {
        return currencyRepo.findByCode(code.toUpperCase());
    }

    public Exchange convertCurrency(String baseCode, String targetCode){

        baseCode = baseCode.toUpperCase();
        targetCode = targetCode.toUpperCase();

        Currency baseCurrency = this.getCurrencyByCode(baseCode);
        Currency targetCurrency = this.getCurrencyByCode(targetCode);

        if(null == baseCurrency){
            //throw error
        }

        if(null == targetCurrency){
            //throw error
        }

        Exchange exchange = new Exchange();

        exchange.setBaseCode(baseCode);
        exchange.setTargetCode(targetCode);

        Float rate = baseCurrency.getRate()/targetCurrency.getRate();

        exchange.setRate(rate);

        return exchange;

    }
}
