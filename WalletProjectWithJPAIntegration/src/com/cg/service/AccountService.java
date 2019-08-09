package com.cg.service;

import java.util.List;
import java.util.Map;

import com.cg.DAO.AccountDAO;
import com.cg.DAO.AccountDAOImpl;
import com.cg.bean.Account;
import com.cg.exception.InsufficientFundException;

public class AccountService implements Transaction, GST {

	AccountDAO dao = new AccountDAOImpl();

	public boolean addAccount(Account ob) {
		return dao.addAccount(ob);
	}

	public Account findAccount(Long mobileno) {
		return dao.findAccount(mobileno);
	}

	public List<Account> getAllAccounts() {
		return dao.getAllAccounts();
	}

	public void deleteAccount(Long mobileno) {
		Account ac = dao.findAccount(mobileno);
		dao.deleteAccount(ac);
	}

	@Override
	public double deposite(Account ob, double amount) {
		// TODO Auto-generated method stub

		double bal = ob.getBalance();
		double upd_bal = bal + amount;
		ob.setBalance(upd_bal);
		boolean b = dao.updateAccount(ob);

		return upd_bal;

	}

	public boolean updateAccount(Account ob) {
		return dao.updateAccount(ob);
	}

	@Override
	public double withdraw(Account ob, double amount) throws InsufficientFundException {
		double new_balance = ob.getBalance() - amount;
		if (new_balance < 100.00) {
			new_balance = ob.getBalance();

			// throw new RuntimeException("Insufficient Fund. Can not proceed further");
			throw new InsufficientFundException("Insufficient Fund. Can not proceed further", new_balance);
		}
		ob.setBalance(new_balance);

		boolean b = dao.updateAccount(ob);
		return new_balance;
	}

	@Override
	public boolean transferMoney(Account from, Account to, double amount) {
		// TODO Auto-generated method stub
		double bal = from.getBalance() - amount;
		double bal1 = to.getBalance() + amount;

		from.setBalance(bal);
		to.setBalance(bal1);

		return true;
	}

	public void printStatement(Account ob) {
		System.out.println("==========================");
		System.out.println("statement for account no" + ob.getAid());

		System.out.println(" account Holder" + ob.getAccountholder());
		System.out.println("balance is =>" + ob.getBalance());
		System.out.println("==========================");
	}

	/*
	 * 
	 * @Override public double calculateTax(double PCT, double amount) { // TODO
	 * Auto-generated method stub return amount*GST.PCT_5; }
	 */

}
