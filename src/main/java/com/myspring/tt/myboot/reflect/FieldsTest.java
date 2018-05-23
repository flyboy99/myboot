package com.myspring.tt.myboot.reflect;

import java.lang.reflect.Field;

public class FieldsTest {

	public static void main(String[] args) throws Exception{
		FieldsTest test = new FieldsTest();
		Class clazz = Class.forName("com.myspring.tt.myboot.reflect.Student");
		
		System.out.println("获取所有 公有字段----");
		Field[] fields = clazz.getFields();
		test.showFields(fields);
		
		System.out.println("所有私有字段....");
	    fields = clazz.getDeclaredFields();
	    test.showFields(fields);
	    
	    Field f = clazz.getField("name");
	    Object obj = clazz.getConstructor().newInstance();
	    f.set(obj, "Honme tonm");
	    
	    Student stu = (Student) obj;
	    System.out.println(stu);
		
		
	}

	public void showFields(Field[] fields){
		for(Field f: fields){
			System.out.println(f);
		}
	}
}
