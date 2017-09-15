package com.mastercard.api.hiring.AppServer.controllers;

import com.mastercard.api.hiring.AppServer.ExceptionHandler.InvalidCurrencyException;
import com.mastercard.api.hiring.AppServer.Service.AlertService;
import com.mastercard.api.hiring.AppServer.Service.CurrencyService;
import com.mastercard.api.hiring.AppServer.entity.Alert;
import com.mastercard.api.hiring.AppServer.entity.Currency;
import com.mastercard.api.hiring.AppServer.model.AlertRequest;
import com.mastercard.api.hiring.AppServer.model.Exchange;
import com.mastercard.api.hiring.AppServer.model.Success;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by e057964 on 14/9/17.
 */
@Controller
@RequestMapping("api")
@EnableAutoConfiguration
public class ApiController {

    @Autowired
    AlertService alertService;

    @Autowired
    CurrencyService currencyService;

    @RequestMapping("currency")
    @ResponseBody
    List<Currency> currencyList() {

        return currencyService.getAllCurrencies();
    }

    @RequestMapping("exchange")
    @ResponseBody
    Exchange exchangeRate(@RequestParam("baseCode") String baseCode, @RequestParam("targetCode")String targetCode) throws InvalidCurrencyException {

        baseCode = baseCode.toUpperCase();
        targetCode = targetCode.toUpperCase();

        Currency baseCurrency = currencyService.getCurrencyByCode(baseCode);
        Currency targetCurrency = currencyService.getCurrencyByCode(targetCode);


        if(null == baseCurrency){
            throw new InvalidCurrencyException(baseCode);
        }

        if(null == targetCurrency){
            throw new InvalidCurrencyException(targetCode);
        }

        return currencyService.convertCurrency(baseCurrency,targetCurrency);
    }

    @RequestMapping(value = "alert",method = RequestMethod.POST)
    @ResponseBody
    Success createAlert(@RequestBody AlertRequest alertRequest) throws MissingServletRequestParameterException, InvalidCurrencyException {

        String code = alertRequest.getCode();

        if(code == null){
            throw new MissingServletRequestParameterException("code", "String");
        }

        Float targetRate = alertRequest.getTargetRate();

        if(targetRate == null){

            throw new MissingServletRequestParameterException("targetRate", "float");
        }

        Currency currency = currencyService.getCurrencyByCode(code);

        if(currency == null){

            throw new InvalidCurrencyException(code);
        }

        Alert alert = new Alert(currency,targetRate);

        alertService.addAlert(alert);

        Success success = new Success();
        success.setMessage("Alert created successfully");

        return success;

    }

}
