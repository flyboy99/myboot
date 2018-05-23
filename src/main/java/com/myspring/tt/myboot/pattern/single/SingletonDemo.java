package com.myspring.tt.myboot.pattern.single;

public class SingletonDemo {
	private static class SingletonHolder{
		private static SingletonDemo instance = new SingletonDemo();
	}
	
	private SingletonDemo(){}
	
	public static SingletonDemo getInstance(){
		return SingletonHolder.instance;
	}
}
