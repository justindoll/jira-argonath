package com.peoplenet.argonath.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value = "/HelloWorld", method = RequestMethod.GET)
    public String custom() {
        logger.info("Now in the HelloWorld controller.");
        return "Frodo, the Argonath! Long have I desired to look upon the kings of old. My kin.";
    }
}