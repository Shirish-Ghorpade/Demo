package com.aurionpro.abstractfactory.model;

public interface IAccount {
	void credit(double amount);
	void debit(double amount);
	long getAccountNumber();
	double getBalance();
}
