package com.vkopendoh.aopdemo.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vkopendoh.aopdemo.Account;

@Component
public class AccountDAO {
	private String theName;
	private boolean check;
	
	public void addAccount(Account account, boolean flag, String name) {		
		
		System.out.println(getClass()+ ": Doing my db work: adding account");
	}
	
	public List<Account> findAccounts(boolean triWire) throws Exception{
		
		if(triWire) {
			throw new RuntimeException("THIS IS Terrible issue!!!(((");
		}
		
		List<Account> accounts = new ArrayList<>();
		
		Account acc1 = new Account("Ivan", "Gold");
		Account acc2 = new Account("Boris", "Silver");
		Account acc3 = new Account("Vasya", "Platinum");
		
		accounts.add(acc1);
		accounts.add(acc2);
		accounts.add(acc3);		
		
		return accounts;
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
