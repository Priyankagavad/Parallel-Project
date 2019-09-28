package com.capgemini.banking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import com.capgemini.banking.bean.Account;
import com.capgemini.banking.exception.AccountNotFoundException;
import com.capgemini.banking.exception.NotSufficientBalanceException;

public class AccountDaoImpl implements AccountDao {

	Account account;
	
	
	
	
	@Override
	public int creatAccount(Account account) throws ClassNotFoundException, SQLException {
		int count = 0;
		int accountNum = account.getAccountNo();
		Connection conn = AccountDB.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select count(*) from bank_wallet_account where accountNo=\'" + accountNum + "\'";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next() && rs.getInt(1) == 0) {
			String insertQuery = "INSERT INTO bank_wallet_account values(?,?,?,?)";
			PreparedStatement pStmt = conn.prepareStatement(insertQuery);
			pStmt.setInt(1, account.getAccountNo());
			pStmt.setString(2, account.getAccountName());
			pStmt.setDouble(3, account.getOpeningBalance());
			pStmt.setDouble(4, account.getCurrentBalance());
			count = pStmt.executeUpdate();

		}
		conn.close();
		if (count > 0)
			return accountNum;
		return (Integer) null;
		
	}

	

	@Override
	public void deposit(int accountNo, int amount) throws AccountNotFoundException, SQLException, ClassNotFoundException, NotSufficientBalanceException{
		if (amount <= 0) {
			throw new NotSufficientBalanceException("Entered Amount is invalid ");
		}

		Connection conn = AccountDB.getConnection();
		Statement stmt = conn.createStatement();
		
		Account account = getAccount(accountNo);
		double newBalance = account.getCurrentBalance() + amount;
		String query = "update bank_wallet_account currentbalance=" + newBalance + " where accountNo=\'" + accountNo + "\'";
		stmt.executeUpdate(query);
		conn.close();
		
	}
	/*@Override
	public double showBalance(int accountNo) throws AccountNotFoundException {
		Account account = hashmap.get(accountNo);
		if (account == null)
			throw new AccountNotFoundException(accountNo + " Account does not exists");
		return hashmap.get(accountNo).getCurrentBalance();
	}

	@Override
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
		
	}

	@Override
	public Collection<Account> printTransactions(int accountNo) {
		return hashmap.values();
	}
*/



	@Override
	public Account getAccount(int accountNo) throws AccountNotFoundException, ClassNotFoundException, SQLException {
		Account account = new Account();
		Connection conn = AccountDB.getConnection();
		Statement stmt = conn.createStatement();
		String query = "select * from bank_wallet_account where accountNo=\'" + accountNo + "\'";
		ResultSet rs = stmt.executeQuery(query);
		if (rs.next()) {
			account.setAccountNo(rs.getInt(1));
			account.setAccountName(rs.getString(2));
			account.setCurrentBalance(rs.getDouble(3));
			account.setOpeningBalance(rs.getDouble(4));
			
			conn.close();
			return account;
		}
		throw new AccountNotFoundException("No account found for account number " + accountNo);
		
	}
}
