package com.myspring.tt.myboot.proxy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootDemoApplication {
	
	@Autowired
	private Person chinese;
	
	@RequestMapping("/test")
	public void test(){
		chinese.sayHello("tomboy");
		System.out.println(chinese.getClass());
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
