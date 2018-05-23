package com.test.proxy;

public class ProxyTestB {

	public static void main(String[] args) {
     CounterProxyB proxyB = new CounterProxyB();
     CountInter count = (CountInter) proxyB.bind(new CounterImpl());
     count.query();
     count.printMsg("abc");
     System.out.println("main end " +count.add());
	}

}
