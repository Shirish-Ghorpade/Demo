package com.aurionpro.abstractfactory.model;

import java.util.Random;
import java.util.Scanner;

public class CurrentAccountFactory implements IAccountFactory {

	@Override
	public IAccount makeAccount() {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the name of account holder ");
		String name = scanner.nextLine();

		System.out.println("Enter the account balance");
		double balance = scanner.nextDouble();

		long accountNumber = setAccountNumber();

		double overDraftLimit = 5000;

		return new CurrentAccount(accountNumber, name, balance, AccountType.CURRENT, overDraftLimit);
	}

	private static long setAccountNumber() {
		Random random = new Random();
		return 10000000000L + (long) (random.nextDouble() * 9000000000L);
	}

}
