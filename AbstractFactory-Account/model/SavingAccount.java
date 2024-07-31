package com.aurionpro.abstractfactory.model;


public class SavingAccount implements IAccount {
	private long accountNumber;
	private String name;
	private double balance;
	private AccountType accountType;
	private double minimumBalance;

	public SavingAccount(long accountNumber, String name, double balance, AccountType accountType,
			double minimumBalance) {
		super();
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = balance;
		this.accountType = accountType;
		this.minimumBalance = minimumBalance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
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

	public void setBankAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public void debit(double amount) {
		if (amount <= 0) {
			System.out.println("Negative or zero amount is not valid");
			return;
		}
		if (amount > balance - minimumBalance) {
			System.out.println("Amount exceed minimum balance");
			return;
		}
		balance -= amount;
		System.out.println("You withdraw " + amount + " so, current balance of "+accountType+" account number "
				+ accountNumber + " is " + balance);
	}

	@Override
	public void credit(double amount) {
		if (amount <= 0) {
			System.out.println("Negative or zero amount is not valid");
			return;
		}
		balance += amount;
		System.out.println("You deposited " + amount + " so, current balance of  "+accountType+" account number "
				+ accountNumber + " is " + balance);
	}

}
