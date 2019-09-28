package com.capgemini.banking.service;

import java.sql.SQLException;


import com.capgemini.banking.bean.Account;
import com.capgemini.banking.dao.AccountDao;
import com.capgemini.banking.dao.AccountDaoImpl;
import com.capgemini.banking.exception.AccountNotFoundException;
import com.capgemini.banking.exception.NotSufficientBalanceException;

public class AccountServiceImpl implements AccountService {

	Account account;
	
	private AccountDao getAccountDao() {
		return new AccountDaoImpl();
	}

	@Override
	public int creatAccount(Account account) throws ClassNotFoundException, SQLException {
		AccountDao accountDao = getAccountDao();
		return accountDao.creatAccount(account);
	}

	@Override
	public void deposit(int accountNo, int amount) throws AccountNotFoundException, ClassNotFoundException, NotSufficientBalanceException, SQLException {
		AccountDao accountDao = getAccountDao();
		accountDao.deposit(accountNo, amount);
	}

	/*@Override
	public void withdraw(int accountNo, int amount) throws AccountNotFoundException, NotSufficientBalanceException {
		Account account = hashmap.get(accountNo);
		if (account == null)
			throw new AccountNotFoundException(accountNo + " Account does not exists");
		double currentBalance = account.getCurrentBalance();
		if (currentBalance <= amount)
			throw new NotSufficientBalanceException(
					accountNo + " Withdrawing amount is greater than available balance");
		currentBalance = currentBalance - amount;
		account.setCurrentBalance(currentBalance);
		hashmap.put(account.getAccountNo(), account);
	}

	@Override
	public double showBalance(int accountNo) throws AccountNotFoundException {
		Account account = hashmap.get(accountNo);
		if (account == null)
			throw new AccountNotFoundException(accountNo + " Account does not exists");
		return hashmap.get(accountNo).getCurrentBalance();

	}

	@Override
	public Collection<Account> printTransactions(int accountNo) {
		return hashmap.values();
	}

	@Override
	public void fundTransfer(int accountNoFrom, int accountNoTo, int amount)
			throws AccountNotFoundException, NotSufficientBalanceException {
		Account accountFrom = hashmap.get(accountNoFrom);
		if (accountFrom == null)
			throw new AccountNotFoundException(accountNoFrom + " Account does not exists");

		Account accountTo = hashmap.get(accountNoTo);
		if (accountTo == null)
			throw new AccountNotFoundException(accountNoTo + " Account does not exists");

		double accountFromBalance = accountFrom.getCurrentBalance();
		if (accountFromBalance >= amount)
			throw new NotSufficientBalanceException(accountNoFrom + " Balance is less than transfer amount");
		accountFromBalance = accountFromBalance - amount;
		accountFrom.setCurrentBalance(accountFromBalance);

		double accountToBalance = accountTo.getCurrentBalance();
		accountToBalance = accountToBalance + amount;
		accountTo.setCurrentBalance(accountToBalance);

		System.out.println("Sender account information: " + accountFrom);
		System.out.println("Receiver account information: " + accountTo);

	}*/
}
