package com.ade.exceptions;

public class EmptyFieldException extends Exception{

	public EmptyFieldException() {
		super("Some fields are empty, please check it");
	}
	
}
