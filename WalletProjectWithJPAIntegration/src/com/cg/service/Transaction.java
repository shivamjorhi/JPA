package com.cg.service;

import com.cg.bean.Account;
import com.cg.exception.InsufficientFundException;

public interface Transaction extends AccountOperation {
	public double withdraw(Account ob, double amount) throws InsufficientFundException;

	public boolean transferMoney(Account from, Account to, double amount);

	public double deposite(Account ob, double amount);
}
