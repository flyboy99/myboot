package com.myspring.tt.myboot.reflect;

public class Student {
	public String name;
	private int age;
	private char sex;
	public String kind;
	
	public Student(){
		System.out.println("默认构造方法，无参..");
	}
	
	public Student(String name){
		this.name = name;
		System.out.println("公有构造方法. 姓名： " + name);
	}
	
	public Student(String name,int age){
		this.name = name;
		this.age = age;
		System.out.println("公有构造方法. 姓名： " + name +" age: " + age);
	}
	
	private Student(int age){
		this.age = age;
		System.out.println("私有构造方法，age " + age);
	}
	
	@Override
	public String toString(){
		return " stu 对象: name="+name +" age="+age
				+ " sex="+sex+" kind="+kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}
	
	public void show1(String s){
		System.out.println("------s="+s);
	}
	
	private void show2(String s){
		System.out.println("私有方法，s="+s);
	}

	private String getMsg(String msg){
		System.out.println("私有方法，msg="+msg);
		return msg+"####";
	}
}
