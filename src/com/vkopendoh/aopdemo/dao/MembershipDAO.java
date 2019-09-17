package com.vkopendoh.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

	public boolean addSillyMethod() {
		System.out.println(getClass() + ": doing stuff: Adding a membership account");
		return true;
	}
}
