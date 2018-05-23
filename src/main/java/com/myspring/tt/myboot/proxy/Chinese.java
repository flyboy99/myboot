package com.myspring.tt.myboot.proxy;

import org.springframework.stereotype.Component;

@Component
public class Chinese implements Person {

	@Timed(value="aaa")
	@Override
	public String sayHello(String name) {
		// TODO Auto-generated method stub
		System.out.println("say hello to" + name);
		return "hello " + name;
	}
	
	public void print(String msg){
		System.out.println("print a msg " + msg);
	}

}
