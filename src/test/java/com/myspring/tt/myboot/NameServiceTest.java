package com.myspring.tt.myboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.myspring.tt.myboot.service.NameService;

public class NameServiceTest {
	@Autowired
	private NameService service; 
	
	public String SayHello(String msg){
		return service.sayHelloToMe(msg);
	}
	
	public static void main(String[] args) {
		/*NameServiceTest test = new NameServiceTest();
		String msg = test.SayHello("bby");
		System.out.println("msg is : " + msg);*/
		AnnotationConfigApplicationContext context 
		  = new AnnotationConfigApplicationContext(DiConfig.class);
		NameServiceTest test = 
				context.getBean(NameServiceTest.class);
		String msg = test.SayHello("bby");
		System.out.println("msg is : " + msg);
		
		context.close();
		
	}
}
