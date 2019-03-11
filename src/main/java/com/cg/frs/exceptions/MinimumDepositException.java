package com.cg.frs.exceptions;

public class MinimumDepositException extends Exception{

	public MinimumDepositException()
	{
		System.err.println("Deposit amount must be greater than rent");
	}
}
