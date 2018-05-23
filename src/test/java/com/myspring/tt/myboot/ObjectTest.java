package com.myspring.tt.myboot;

public class ObjectTest {

	public static void main(String[] args) {
		Son s1 = new Son("aaa",10);
		Son s2 = new Son("aaa",10);	
	
		System.out.println(s1==s2);
		
		Son s3 = s1;
		System.out.println(s1==s3);
		
		ObjectTest test = new ObjectTest();
		test.charge1(s1);
		System.out.println(s1.getName()+"  " + s1.getAge());
		
		Son s = test.getSon(s1);
		System.out.println(s==s1);
	}
	
	public void swap(Son s1,Son s2){
		Son s = new Son();
		
	}
	
	public void charge1(Son s1){
		s1.setName("ccc");
		s1.setAge(20);
	}
	
	public Son getSon(Son s1){
	//	s1.setName("ccc");
	//	s1.setAge(20);
		return s1;
		
	}
}
