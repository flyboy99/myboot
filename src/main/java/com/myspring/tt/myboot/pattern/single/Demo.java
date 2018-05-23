package com.myspring.tt.myboot.pattern.single;

public class Demo {
	private volatile static Demo instance;
	
	private Demo(){
		System.out.println("object init..");
		
	}
	public static Demo getInstance(){
		if(null==instance){
			synchronized(Demo.class){
				if(null==instance){
					instance = new Demo();
				}
			}
		}
		return instance;
	}
}
