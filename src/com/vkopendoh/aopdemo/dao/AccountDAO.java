package com.vkopendoh.aopdemo.dao;

import org.springframework.stereotype.Component;

import com.vkopendoh.aopdemo.Account;

@Component
public class AccountDAO {
	private String theName;
	private boolean check;
	
	public void addAccount(Account account, boolean flag, String name) {
		
		
		System.out.println(getClass()+ ": Doing my db work: adding account");
	}
	
	public String doWork() {
		System.out.println(getClass()+ ": Doing work!!: doWork()");
		return "";
	}

	public String getTheName() {
		System.out.println(getClass()+ "Getter|setter");
		return theName;
	}

	public void setTheName(String theName) {
		System.out.println(getClass()+ "Getter|setter");
		this.theName = theName;
	}

	public boolean getCheck() {
		System.out.println(getClass()+ "Getter|setter");
		return check;
	}

	public void setCheck(boolean check) {
		System.out.println(getClass()+ "Getter|setter");
		this.check = check;
	}
	
	
}
