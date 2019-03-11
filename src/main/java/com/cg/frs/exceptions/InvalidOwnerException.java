package com.cg.frs.exceptions;

public class InvalidOwnerException extends Exception{

	public InvalidOwnerException()
	{
		System.err.println("Owner does not exists");
	}
}
