package com.test.proxy;

public class ProxyTestA {

	public static void main(String[] args) {
      CounterImpl implA = new CounterImpl();
      CounterProxyA proxyA = new CounterProxyA(implA);
      proxyA.query();
      System.out.println("main method.." + proxyA.add());
	}

}
