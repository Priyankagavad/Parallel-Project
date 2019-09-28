package com.capgemini.banking.bean;

public class Account {
	private String accountName;
	private int accountNo;
	private double openingBalance;
	private double currentBalance;

	public Account(String accountName, double openingBalance) {
		super();
		setAccountName(accountName);
		int accountNo = (int) (Math.random() * 100);
		setAccountNo(accountNo);
		setOpeningBalance(openingBalance);
		setCurrentBalance(openingBalance);
	}

	public Account() {
		super();
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public int getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	public double getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	@Override
	public String toString() {
		return String.format("Account [accountName=%s, accountNo=%s, openingBalance=%s, currentBalance=%s]",
				accountName, accountNo, openingBalance, currentBalance);
	}
}
