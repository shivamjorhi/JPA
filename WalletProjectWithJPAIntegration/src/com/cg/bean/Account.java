package com.cg.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Account {
	@Column(name = "aid")
	private int aid;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@Column(name = "mobile")
	private long mobile;
	@Column(name = "accountholder", length = 25)
	private String accountholder;
	@Column(name = "balance")
	private double balance;

	public Account(int aid, long mobile, String accountholder, double balance) {
		super();
		this.aid = aid;
		this.mobile = mobile;
		this.accountholder = accountholder;
		this.balance = balance;
	}

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public long getMobile() {
		return mobile;
	}

	public void setMobile(long mobile) {
		this.mobile = mobile;
	}

	public String getAccountholder() {
		return accountholder;
	}

	public void setAccountholder(String accountholder) {
		this.accountholder = accountholder;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [aid=" + aid + ", mobile=" + mobile + ", accountholder=" + accountholder + ", balance="
				+ balance + "]";
	}

}
