package com.cg.bean;

public class SavingAccount extends Account{
	private double interest;
	
	
	public SavingAccount(int aid, int mobile, String accountholder, double balance) {
		super(aid, mobile, accountholder, balance);
		// TODO Auto-generated constructor stub
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest() {
		this.interest = super.getBalance()*.04;
	}
	@Override
	public String toString() {
		return super.toString()+"SavingAccount [interest=" + interest + "]";
	}
	

}
