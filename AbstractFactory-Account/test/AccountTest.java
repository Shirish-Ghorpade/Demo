package com.aurionpro.abstractfactory.test;

import java.util.Scanner;

import com.aurionpro.abstractfactory.model.CurrentAccountFactory;
import com.aurionpro.abstractfactory.model.IAccount;
import com.aurionpro.abstractfactory.model.IAccountFactory;
import com.aurionpro.abstractfactory.model.SavingAccountFactory;

public class AccountTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double amount;

		boolean exitOption = false;
		IAccountFactory accountFactory;
		IAccount account = null;

		while (!exitOption) {
			System.out.println("----------------------------------------------------------------");

			System.out.println("1. Create Saving account");
			System.out.println("2. Create Current account");
			System.out.println("3. Check Balance");
			System.out.println("4. Deposit Money");
			System.out.println("5. Withdraw Money");
			System.out.println("6. Exit");
			System.out.println("Please choose an option: ");
			int response = scanner.nextInt();
			switch (response) {
			case 1:
				accountFactory = new SavingAccountFactory();
				account = accountFactory.makeAccount();
				break;
			case 2:
				accountFactory = new CurrentAccountFactory();
				account = accountFactory.makeAccount();
				break;
			case 3:
				System.out.println("Current balance of account number " + account.getAccountNumber() + " is "
						+ account.getBalance());
				break;
			case 4:
				System.out.println("Enter the deposit amount");
				amount = scanner.nextLong();
				account.credit(amount);
				break;

			case 5:
				System.out.println("Enter the withdrawl amount");
				amount = scanner.nextLong();
				account.debit(amount);
				break;
			case 6:
				exitOption = true;
				System.out.println("Thank You !!!");
				break;
			default:
				System.out.println("Invalid input");
			}
		}

	}

}
