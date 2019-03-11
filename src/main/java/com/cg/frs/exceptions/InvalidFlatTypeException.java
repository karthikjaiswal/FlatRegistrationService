package com.cg.frs.exceptions;

public class InvalidFlatTypeException extends Exception {

	public InvalidFlatTypeException()
	{
		System.err.println("Flat Type does not exist");
	}
}
