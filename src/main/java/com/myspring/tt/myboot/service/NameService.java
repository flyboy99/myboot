package com.myspring.tt.myboot.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.myspring.tt.myboot.domain.TestProperties;

@Service
public class NameService {
	
	private TestProperties prop;
	
	public String sayHelloToMe(String msg){
		return "hello " + msg;
	}
}
