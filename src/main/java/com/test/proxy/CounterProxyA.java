package com.test.proxy;

public class CounterProxyA implements CountInter {
    private CountInter counter;
	
    public CounterProxyA(CountInter counter)
    {
    	this.counter = counter;
    }
    
	@Override
	public void query() {
		System.out.println("查询方法前。。");
		this.counter.query();
		System.out.println("查询方法后。。");
	}

	@Override
	public String add() {
		System.out.println("查询方法前 2222222。。");
		return this.counter.add();
		
	}
	
	public void printMsg(String msg){
		
	}
}
