package com.cg.DAO;

import java.util.List;
import java.util.Map;

import com.cg.bean.Account;

public interface AccountDAO {

	public boolean addAccount(Account ob);// success

	public Account findAccount(Long mobileno);// success

	public List<Account> getAllAccounts();

	public void deleteAccount(Account ob);// success

	public boolean updateAccount(Account ob);

}
