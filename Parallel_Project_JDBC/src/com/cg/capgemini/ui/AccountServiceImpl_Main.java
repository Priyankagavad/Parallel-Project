package com.cg.capgemini.ui;

import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.banking.bean.Account;
import com.capgemini.banking.exception.AccountNotFoundException;
import com.capgemini.banking.exception.NotSufficientBalanceException;
import com.capgemini.banking.service.AccountService;
import com.capgemini.banking.service.AccountServiceImpl;

public class AccountServiceImpl_Main {

	public static void main(String[] args) {

		AccountService accountService = new AccountServiceImpl();

		int choice, accountNo = 0, amount = 0;
		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Welcome to World Bank...");
			System.out.println("1. Create Account");
			System.out.println("2. Show Balance");
			System.out.println("3. Deposit");
			System.out.println("4. Withdraw");
			System.out.println("5. Fund Transfer");
			System.out.println("6. Print Transactions");
			System.out.println("7. Exit");
			System.out.println("Enter choice: ");
			choice = sc.nextInt();

			switch (choice) {
			/*case 1:
				Account account;
				String accountName;
				double openingBalance;
				try{
				System.out.println("Enter the opening account balance:");
				openingBalance = sc.nextDouble();
				System.out.println("Enter account name: ");
				accountName = sc.next();

				account = new Account(accountName, openingBalance);
				System.out.println("Account:" + account);
				
					accountService.creatAccount(account);
				} catch (ClassNotFoundException e) {
					System.out.println(e.getMessage());
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}

				System.out.println("Account is created ");

				break;*/

			/*case 2:
				System.out.println("Enter account no:");
				accountNo = sc.nextInt();
				try {
					System.out.println("Account balance is: " + accountService.showBalance(accountNo));
				} catch (AccountNotFoundException e1) {
					System.err.println(e1.getMessage());
				}
				break;*/

			case 3:
				System.out.println("Enter account no: ");
				accountNo = sc.nextInt();
				System.out.println("Enter amount: ");
				amount = sc.nextInt();
				try {
					try {
						accountService.deposit(accountNo, amount);
					} catch (ClassNotFoundException e) {
						System.out.println(e.getMessage());
					} catch (NotSufficientBalanceException e) {
						System.out.println(e.getMessage());
					} catch (SQLException e) {
					
					}
					System.out.println(amount + " RS deposited in your account");
				} catch (AccountNotFoundException e) {
					System.err.println(e.getMessage());
				}
				break;

			/*case 4:
				System.out.println("Enter account no: ");
				accountNo = sc.nextInt();
				System.out.println("Enter amount: ");
				amount = sc.nextInt();
				try {
					accountService.withdraw(accountNo, amount);
					System.out.println(amount + " RS withdrawn from your account");
				} catch (AccountNotFoundException e) {
					System.err.println(e.getMessage());
				} catch (NotSufficientBalanceException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 5:
				System.out.println("Enter account number from: ");
				int accountNoFrom = sc.nextInt();
				System.out.println("Enter account number to: ");
				int accountNoTo = sc.nextInt();
				System.out.println("Enter amount: ");
				amount = sc.nextInt();
				try {
					accountService.fundTransfer(accountNoFrom, accountNoTo, amount);
				} catch (AccountNotFoundException e) {
					System.err.println(e.getMessage());
				} catch (NotSufficientBalanceException e) {
					System.err.println(e.getMessage());
				}
				break;

			case 6:
				System.out.println("Enter account no: ");
				accountNo = sc.nextInt();
				System.out.println("Account transactions: " + accountService.printTransactions(accountNo));
				break;
*/
			default:
				System.out.println("Exit");
			}
		} while (choice != 7);
		sc.close();
	}
}
