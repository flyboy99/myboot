package com.test.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 动态代理，通过实现 InvocationHandler接口方式实现，接口方式
 */
public class CounterProxyB implements InvocationHandler {
	private Object target;	
	
	public Object bind(Object target){
		this.target = target;
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),
				target.getClass().getInterfaces(), this);
	}
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("开始动态代理。。。");
		Object result = method.invoke(target, args);
		System.out.println("动态代理结束....");
		return result;
	}

}
