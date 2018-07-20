package com.cg.pizzaorder.exception;

public class PizzaException extends Exception {
	
	String msg="";
	public PizzaException() {
		super();
		
		// TODO Auto-generated constructor stub
	}

	public PizzaException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

	public PizzaException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public PizzaException(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public PizzaException(Throwable arg0) {
		super(arg0);
		this.msg=msg;
		// TODO Auto-generated constructor stub
	}
	public String getMessage()
	{
		System.out.println(msg);
		return msg;
	}
}
