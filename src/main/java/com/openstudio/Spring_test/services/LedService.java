package com.openstudio.Spring_test.services;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Timer;
import java.util.TimerTask;

@Service
public class LedService {
    private boolean on;

    public void setOn(boolean on) {
        this.on = on;
    }

    public boolean isOn() {
        return on;
    }

    @PostConstruct
    public void init() {
        on = true;
    }

    public void stopAll() {
        on = false;
    }
}
