package com.myspring.tt.myboot.reflect;

import java.lang.reflect.Method;

public class MethodTest {

	public static void main(String[] args) throws Exception{
		MethodTest test = new MethodTest();
		
		Class clazz = Class.forName("com.myspring.tt.myboot.reflect.Student");
		System.out.println("所有公有方法。。");
		Method[] ms = clazz.getMethods();
		test.showMethod(ms);
		
		System.out.println("---所有私有方法...");
		ms = clazz.getDeclaredMethods();
		test.showMethod(ms);
		
		System.out.println("获得一个方法并执行...");
		Method m = clazz.getMethod("show1", String.class);
		
		Object obj = clazz.getConstructor().newInstance();
		m.invoke(obj, "I'm lim");
		
	}
	
	public void showMethod(Method[] ms){
		for(Method m : ms){
			System.out.println(m);
		}
	}
}
