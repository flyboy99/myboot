package com.myspring.tt.myboot.thread.product;

public class Test {
	public static void main(String[] args) {
		test1();
	}
	public static void test1(){
		Storage storage = new Storage();
		//产生5个生产者。。//5个消费者
		for(int i=0;i<5;i++){
			Produce produce = new Produce();
			produce.setName("pro" + i);
			produce.setStorage(storage);
			Thread t = new Thread(produce);
			t.start();
			
			//consume
			Consume consume = new Consume();
			consume.setName("con" + i);
			consume.setStorage(storage);
			Thread c = new Thread(consume);
			c.start();
		}
		
	
	}
}
