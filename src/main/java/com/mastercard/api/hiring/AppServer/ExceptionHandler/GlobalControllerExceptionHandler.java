package com.mastercard.api.hiring.AppServer.ExceptionHandler;

import com.mastercard.api.hiring.AppServer.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by e057964 on 15/9/17.
 */
@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorResponse> handleMissingParams(MissingServletRequestParameterException ex) {
        String name = ex.getParameterName();
        System.out.println(name + " parameter is missing");
        return createResponseEntity(1,"Required parameter "+name+" is missing",HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(InvalidCurrencyException.class)
    public ResponseEntity<ErrorResponse> handleMissingParams(InvalidCurrencyException ex) {
        String currency = ex.getCurrCode();
        System.out.println(currency + " does not exist");
        return createResponseEntity(2,"Currency with code "+currency+" does not exist",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private ResponseEntity<ErrorResponse> createResponseEntity(int code, String message,HttpStatus status){
        ErrorResponse error = new ErrorResponse(code,message);
        ResponseEntity<ErrorResponse> re = new ResponseEntity<ErrorResponse>(error, status);
        return re;
    }
}
