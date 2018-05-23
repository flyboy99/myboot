package com.myspring.tt.myboot.pattern.single;

public class SingleInstance {
	private static SingleInstance instance = null;
	
	private SingleInstance(){
		
	}
	
	public static synchronized SingleInstance getInstance(){
		if(null==instance){
			instance = new SingleInstance();
		}
		return instance;
	}
	
}
