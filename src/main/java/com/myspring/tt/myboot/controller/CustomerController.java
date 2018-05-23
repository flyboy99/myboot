package com.myspring.tt.myboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.tt.myboot.domain.TestProperties;
import com.myspring.tt.myboot.domain.User;

@RestController
public class CustomerController {
	
	@Autowired
	private CounterService counter;
	
	@Autowired
    private TestProperties prop;
	
	@RequestMapping("/hello")
	public String index(){
		return "hello world";
	}
	
	@RequestMapping("/getUser")
    public User getUser(){
		User user = new User();
		user.setName("xiaoliang");
		user.setPwd("123");
		return user;
	}
	
	@RequestMapping("/getProp")
	public TestProperties getProperties(){
		counter.decrement("access getProp counter..");
		
		System.out.println("获得的prop 是：" + prop.toString());
		return prop;
	}

}
