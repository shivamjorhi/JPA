package com.cg.service;

import java.util.List;
import java.util.Map;

import com.cg.bean.*;

public interface AccountOperation {

	public boolean addAccount(Account ob);

	public void deleteAccount(Long mobileno);

	public Account findAccount(Long mobileno);

	public List<Account> getAllAccounts();

}
