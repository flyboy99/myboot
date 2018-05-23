package com.myspring.tt.myboot.proxy;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class BookFacadeCglib implements MethodInterceptor {
	private Object target;
	
	public Object getInstance(Object target){
		this.target = target;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.target.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
	
	@Override
	public Object intercept(Object object, Method method, Object[] args,
			MethodProxy proxy) throws Throwable {
		System.out.println("代理开始..");
		proxy.invokeSuper(object, args);
		System.out.println("代理结束。。");
		return null;
	}
	
	public static void main(String[] args) {
		BookFacadeCglib cglib = new BookFacadeCglib();
		BookFacade bookFacade = (BookFacade)cglib.getInstance(new BookFacadeImpl());
		bookFacade.addBook();
		System.out.println("######");
		bookFacade.printMsg("mmm");
	}
}
