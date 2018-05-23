package com.myspring.tt.myboot.reflect;

import java.lang.reflect.Constructor;

public class ConstructorTest {

	public static void main(String[] args) throws Exception {
		ConstructorTest test = new ConstructorTest();
	
			Class clazz = Class.forName("com.myspring.tt.myboot.reflect.Student");
			
			System.out.println("所有公有构造方法:");
			Constructor[] conArray = clazz.getConstructors();
			for(Constructor con : conArray){
				System.out.println(con);
			}
			
			System.out.println("所有构造方法，包括公有，私有方法.......");
			conArray = clazz.getDeclaredConstructors();
			test.showCons(conArray);
			
			System.out.println("公有无参的构造方法。。");
			Constructor con = clazz.getConstructor(null);
			System.out.println(con);
			
			Object obj = con.newInstance();
			Student stu = (Student) obj;
			System.out.println(stu);
		
			System.out.println("----------获得私有构造方法....");
			con = clazz.getDeclaredConstructor(int.class);
			System.out.println(con);
			
			con.setAccessible(true);
			obj = con.newInstance(20);
			stu = (Student) obj;
			System.out.println(stu.getAge());
	}

	public void showCons(Constructor[] conArray){
		for(Constructor c : conArray){
			System.out.println(c);
		}
	}
}
