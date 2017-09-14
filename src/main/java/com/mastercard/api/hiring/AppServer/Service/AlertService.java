package com.mastercard.api.hiring.AppServer.Service;

import com.mastercard.api.hiring.AppServer.dao.IAlertDao;
import com.mastercard.api.hiring.AppServer.entity.Alert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by e057964 on 14/9/17.
 */
@Service
public class AlertService implements IAlertService {

    @Autowired
    IAlertDao alertDao;


    @Override
    public void addAlert(Alert alert) {
        alertDao.save(alert);
    }
}
