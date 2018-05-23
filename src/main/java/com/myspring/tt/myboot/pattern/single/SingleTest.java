package com.myspring.tt.myboot.pattern.single;

public class SingleTest {

	public static void main(String[] args) {
		test3();
		
	}
	public static void test3(){
		Demo d1 = Demo.getInstance();
		Demo d2 = Demo.getInstance();
		System.out.println(d1==d2);
	}
	
	public static void test2(){
		SingletonDemo demo = SingletonDemo.getInstance();
		SingletonDemo demo2 = SingletonDemo.getInstance();
		System.out.println(demo==demo2);
	}
	
	public static void test1(){
		SingleInstance in1 = SingleInstance.getInstance();
		SingleInstance in2 = SingleInstance.getInstance();
		SingleInstance in3 = SingleInstance.getInstance();
		System.out.println(in1==in2);
		System.out.println(in1==in3);
	}

}
