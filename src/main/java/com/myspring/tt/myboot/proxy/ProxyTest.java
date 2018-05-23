package com.myspring.tt.myboot.proxy;

public class ProxyTest {

	public static void main(String[] args) {
		BookFacadeCglib bookCglib = new BookFacadeCglib();
		BookFacadeImpl bookImpl = (BookFacadeImpl) bookCglib.getInstance(new BookFacadeImpl());
	    bookImpl.addBook();
	}

}
