package com.capgemini.banking.service;

import java.sql.SQLException;
import java.util.Collection;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.exception.AccountNotFoundException;
import com.capgemini.banking.exception.NotSufficientBalanceException;

public interface AccountService {

	public int creatAccount(Account account) throws ClassNotFoundException, SQLException;
	
	public void deposit(int accountNo, int amount) throws AccountNotFoundException, ClassNotFoundException, NotSufficientBalanceException, SQLException;

	/*public double showBalance(int accountNo) throws AccountNotFoundException;

	

	public void withdraw(int accountNo, int amount) throws AccountNotFoundException, NotSufficientBalanceException;

	public void fundTransfer(int accountNoFrom, int accountNoTo, int amount)
			throws AccountNotFoundException, NotSufficientBalanceException;

	public Collection<Account> printTransactions(int accountNo);*/
}
