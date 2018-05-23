package com.myspring.tt.myboot.proxy;

public class BookFacadeImpl implements BookFacade {
  public void addBook(){
	  System.out.println("add a book...");
  }

@Override
public void printMsg(String msg) {
	System.out.println(this.getClass().getCanonicalName() +" print msg " +msg);
	
}
}
