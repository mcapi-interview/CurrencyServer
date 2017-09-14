package com.mastercard.api.hiring.AppServer.dao;

import com.mastercard.api.hiring.AppServer.entity.Currency;
import org.springframework.data.repository.CrudRepository;


/**
 * Created by e057964 on 14/9/17.
 */
public interface ICurrencyDao extends CrudRepository<Currency, Long> {

    Currency findByCode(String code);

}
