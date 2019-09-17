package com.vkopendoh.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public void addSillyMethod() {
		System.out.println(getClass() + ": doing stuff: Adding a membership account");
	}
}
