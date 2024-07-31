package com.aurionpro.abstractfactory.model;

import com.aurionpro.abstractfactory.model.AccountType;

public class CurrentAccount implements IAccount {

	private long accountNumber;
	private String name;
	private double balance;
	private AccountType accountType;
	private double overDraftLimit;

	public CurrentAccount(long accountNumber, String name, double balance, AccountType bankAccountType,
			double overDraftLimit) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.accountType = bankAccountType;
		this.overDraftLimit = overDraftLimit;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getOverDraftLimit() {
		return overDraftLimit;
	}

	public void setOverDraftLimit(double overDraftLimit) {
		this.overDraftLimit = overDraftLimit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void credit(double amount) {
		if (amount <= 0) {
			System.out.println("Negative or zero amount is not valid");
			return;
		}
		balance += amount;
		System.out.println("You deposited " + amount + " so, current balance of "+accountType+" account number "
				+ accountNumber + " is " + balance);
	}

	public void debit(double amount) {
		if (amount <= 0) {
			System.out.println("Negative or zero amount is not valid");
			return;
		}
		if (amount > balance + overDraftLimit) {
			System.out.println("Amount exceed overdraft limit also");
			return;
		}
		if (amount <= balance) {
			balance -= amount;
		} else if (amount <= balance + overDraftLimit) {
			balance -= amount;
		}
		System.out.println("You withdraw " + amount + " so, current balance of "+accountType+" account number " + accountNumber + " is "
				+ balance);
	}
}
