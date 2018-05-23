package com.myspring.tt.myboot.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AdviceTest {
	
	@Pointcut("@annotation(com.myspring.tt.myboot.proxy.Timed)")
	public void pontcut(){
		
	}
	
	@Before("pintcut()")
	public void before(){
		System.out.println("before");
	}
}
