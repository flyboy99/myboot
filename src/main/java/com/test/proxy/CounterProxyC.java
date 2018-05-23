package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CounterProxyC implements InvocationHandler {
	private Object target;
	
	public Object bind(Object obj){
		this.target = obj;
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(),
				obj.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("代理方法执行前：");
		method.invoke(target, args);
		System.out.println("代理方法执行后。。。。。");
		return null;
	}

}
