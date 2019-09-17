package com.vkopendoh.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.vkopendoh.aopdemo.Account;

@Component
public class AccountDAO {

	public void addAccount(Account account) {
		System.out.println(getClass()+ ": Doing my db work: adding account");
	}
}
