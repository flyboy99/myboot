package com.myspring.tt.myboot.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestProperties {
	
  @Value("ddd ttt")
  private String title;
  
  @Value("apple")
  private String desc;

public String getTitle() {
	return title;
}

public void setTitle(String title) {
	this.title = title;
}

public String getDesc() {
	return desc;
}

public void setDesc(String desc) {
	this.desc = desc;
}

@Override
public String toString() {
	return "TestProperties [title=" + title + ", desc=" + desc + "]";
}
  
  
}
