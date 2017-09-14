package com.mastercard.api.hiring.AppServer.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by e057964 on 14/9/17.
 */
@Controller
public class HomeController {


    @RequestMapping("/")
    @ResponseBody
    String home() {

        return "App running";
    }
}
