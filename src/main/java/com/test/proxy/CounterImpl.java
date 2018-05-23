package com.test.proxy;

public class CounterImpl implements CountInter {

	@Override
	public void query() {
       System.out.println("This is counter impl query..");
	}

	@Override
	public String add() {
		System.out.println("This is counter impl add..");
		
		return "add method..";
	}
	
	public void printMsg(String msg){
		System.out.println("impl msg print..,,");
		System.out.println("The msg is " + msg);
	}

}
