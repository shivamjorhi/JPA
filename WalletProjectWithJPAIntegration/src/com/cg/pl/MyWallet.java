package com.cg.pl;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.cg.service.*;

import com.cg.bean.*;
import com.cg.exception.InsufficientFundException;

public class MyWallet {
	public static void main(String[] args) throws IOException, InsufficientFundException {

		AccountService service = new AccountService();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String choice = "";
		while (true) {
			System.out.println("Welcome, you can do following");
			System.out.println("=======");
			System.out.println("1. Add a new Account");// success
			System.out.println("2. deposite money in account");// success
			System.out.println("3. Delete Account");// success
			System.out.println("4. Find account");// success
			System.out.println("5. Withdraw money");// success
			System.out.println("6. Transfer Money");// success
			System.out.println("7. Get all accounts");// success

			choice = br.readLine();
			switch (choice) {
			case "1":
				int id = 0;// adding a new account
				long mb = 0L;
				String ah = "";
				double bal = 0.0;
				// Accepting and validating input for account
				System.out.println("Enter account number");
				while (true) {
					String s_id = br.readLine();
					boolean ch1 = Validator.validatedata(s_id, Validator.aidpattern);
					if (ch1 == true) {
						try {
							id = Integer.parseInt(s_id);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Account number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter Account Number");
					}
				}
				System.out.println("Enter mobile number");
				while (true) {
					String s_mb = br.readLine();
					boolean ch1 = Validator.validatedata(s_mb, Validator.mobilepattern);
					if (ch1 == true) {
						try {
							mb = Long.parseLong(s_mb);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Mobile number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter Account Number in 10 digits");
					}
				}

				System.out.println("Enter account holder name");
				// accepting and validating the account holder

				while (true) {
					String s_name = br.readLine();
					boolean ch1 = Validator.validatedata(s_name, Validator.namepattern);
					if (ch1 == true) {
						try {
							ah = s_name;
							break;
						} catch (Exception e) {
							System.out.println("Account holder name must be in correct format. Re enter");
							e.printStackTrace();
						}
					} else
						System.out.println("Re enter the name");
				}
				System.out.println("Enter initial balance");

				// accepting and validating balance

				while (true) {
					String s_bal = br.readLine();
					boolean ch1 = Validator.validatedata(s_bal, Validator.salarypattern);
					if (ch1 == true) {
						try {
							bal = Double.parseDouble(s_bal);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Account balance must be numeric. Re Enter");
							e.printStackTrace();
						}
					} else
						System.out.println("Re enter Balance");
				}

				Account ob = new Account(id, mb, ah, bal);

				boolean b = service.addAccount(ob);
				System.out.println(b);
				break;

			case "2": // depositing money
				System.out.println("Enter the mobile number associated with the account");

				long mb4 = 0;
				while (true) {
					String s_mb = br.readLine();
					boolean ch1 = Validator.validatedata(s_mb, Validator.mobilepattern);
					if (ch1 == true) {
						try {
							mb4 = Long.parseLong(s_mb);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Mobile number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter Account Number in 10 digits");
					}
				}
				System.out.println("Enter the amount to be deposited in this account");
				String s_bal1 = br.readLine();

				double bal2 = Double.parseDouble(s_bal1);
				Account obb = service.findAccount(mb4);
				double b5 = service.deposite(obb, bal2);
				System.out.println("The updated balance is " + b5);

				break;

			case "3": // deleting account number
				System.out.println("Enter the mobile number which account is to be deleted");
				long mb2 = 0;
				while (true) {
					String s_mb = br.readLine();
					boolean ch1 = Validator.validatedata(s_mb, Validator.mobilepattern);
					if (ch1 == true) {
						try {
							mb2 = Long.parseLong(s_mb);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Mobile number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter Account Number in 10 digits");
					}
				}

				service.deleteAccount(mb2);

				System.out.println(mb2 + " account deleted");
				break;

			case "4":// find by mobile number

				long mb1 = 0;
				System.out.println("Enter mobile number");
				while (true) {
					String s_mb = br.readLine();
					boolean ch1 = Validator.validatedata(s_mb, Validator.mobilepattern);
					if (ch1 == true) {
						try {
							mb1 = Long.parseLong(s_mb);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Mobile number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter mobile Number in 10 digits");
					}
				}

				Account b3 = service.findAccount(mb1);

				service.printStatement(b3);

				break;

			case "5": // withdraw money
				System.out.println("Enter the amount to be withdrawn");

				double bal0 = 0.0;

				while (true) {
					String s_bal0 = br.readLine();
					boolean ch1 = Validator.validatedata(s_bal0, Validator.salarypattern);

					if (ch1 == true) {
						try {
							bal0 = Double.parseDouble(s_bal0);
							break;
						} catch (Exception e) {
							System.out.println("Account balance must be numeric. Re Enter");
							e.printStackTrace();
						}
					} else
						System.out.println("Re enter Balance");
				}

				System.out.println("Enter the mobile number associated with the account");

				long mob0 = 0l;
				while (true) {
					String s_mb0 = br.readLine();
					boolean ch1 = Validator.validatedata(s_mb0, Validator.mobilepattern);
					if (ch1 == true) {
						try {
							mb = Long.parseLong(s_mb0);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Mobile number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter Mobile Number in 10 digits");
					}
				}
				Account obb1 = service.findAccount(mb);
				double upd_bal = service.withdraw(obb1, bal0);

				System.out.println("The updated Balance is : " + upd_bal);

				break;

			case "6": // transfer money
				System.out.println("Enter the mobile number of the account from which amount is to be transferred");

				long from = 0L;

				while (true) {
					String s_bal2 = br.readLine();
					boolean ch1 = Validator.validatedata(s_bal2, Validator.mobilepattern);
					if (ch1 == true) {
						try {
							from = Long.parseLong(s_bal2);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Mobile number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter Mobile Number in 10 digits");
					}
				}

				System.out.println("Enter the mobile number of the account to which amount is to be credited");

				long to = 0l;

				while (true) {
					String s_bal22 = br.readLine();
					boolean ch1 = Validator.validatedata(s_bal22, Validator.mobilepattern);
					if (ch1 == true) {
						try {
							to = Long.parseLong(s_bal22);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Mobile number must be numeric. Re enter");
							e.printStackTrace();
						}
					} else {
						System.out.println("Re enter Mobile Number in 10 digits");
					}
				}

				System.out.println("Enter the amount to be transferred");

				double money1 = 0.0;

				while (true) {
					String money = br.readLine();
					boolean ch1 = Validator.validatedata(money, Validator.salarypattern);
					if (ch1 == true) {
						try {
							money1 = Double.parseDouble(money);
							break;
						} catch (NumberFormatException e) {
							System.out.println("Account balance must be numeric. Re Enter");
							e.printStackTrace();
						}
					} else
						System.out.println("Re enter Balance");
				}

				boolean success = service.transferMoney(service.findAccount(from), service.findAccount(to), money1);

				if (success) {
					service.updateAccount(service.findAccount(from));
					service.updateAccount(service.findAccount(to));
				}

				break;

			case "7": // get all accounts
				List<Account> accounts = service.getAllAccounts();
				for (Account o : accounts)
					System.out.println(o);
				break;

			default:
				System.out.println("Invalid choice");

			}
		}
	}
}
