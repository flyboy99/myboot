package com.test.proxy;

public class ProxyTestC {
	public static void main(String[] args) {
		CounterProxyC proxyc = new CounterProxyC();
		CountInter cinter = (CountInter) proxyc.bind(new CounterImpl());
		cinter.add();
		cinter.query();
		System.out.println("################");
		cinter.printMsg("heeee");
		
	}
}
