package com.mbarekDev.aopdemo.service;

import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TrafficFortuneServiceImpl implements TrafficFortuneService {
    @Override
    public String getFortune() {
        // simulate a delay
        try {
            TimeUnit.SECONDS.sleep(5);


        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return " Expecte heavy traffic this morning ---> ";
    }

    @Override
    public String getFortune(boolean theTripWire) {
        if (theTripWire) {
            throw new RuntimeException(" throw RuntimeException --->");
        }
        return getFortune();
    }
}
