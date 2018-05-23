package com.myspring.tt.myboot.thread.product;

public class Consume implements Runnable {
	private String name;
	
	private Storage storage;
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Storage getStorage() {
		return storage;
	}



	public void setStorage(Storage storage) {
		this.storage = storage;
	}



	@Override
	public void run() {
		System.out.println("消费者内部 开始。。。");		
		//while(true){
			storage.consume(name);
			
		//}
		//System.out.println("消费者结束。。。");
	}

}
