package com.aurionpro.abstractfactory.model;

import java.util.Random;
import java.util.Scanner;
import com.aurionpro.abstractfactory.model.AccountType;



public class SavingAccountFactory implements IAccountFactory{
	
	@Override
	public IAccount makeAccount() {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the name of account holder ");
		String name = scanner.nextLine();
		
		System.out.println("Enter the account balance");
		double balance = scanner.nextDouble();
		
		long accountNumber = setAccountNumber();
		
		double minimumBalance = 500;
		
		return new SavingAccount(accountNumber, name, balance, AccountType.SAVING, minimumBalance);
		
	}
	private static long setAccountNumber() {
		Random random = new Random();
		return 10000000000L + (long) (random.nextDouble() * 9000000000L);
	}

}
