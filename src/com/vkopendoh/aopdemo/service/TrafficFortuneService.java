package com.vkopendoh.aopdemo.service;

import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class TrafficFortuneService {
	public String getFortune() {
		//simulate delay
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
		
		return "Here havy traffic!!";
	}

	public String getFortune(boolean tripWire) {
		if(tripWire) {
			throw new RuntimeException("Accident happens!!");
		}
		return getFortune();
	}
}
