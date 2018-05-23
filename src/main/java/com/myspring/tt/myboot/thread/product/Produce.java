package com.myspring.tt.myboot.thread.product;

public class Produce implements Runnable{

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
	
	public void run() {
		System.out.println("#### 生产者线程内部...");
	//	for(int i=0;i<5;i++){
	//		storage.produce("car"+i, name);
	//	}
	//	while(true){
			storage.produce("car"+0, name);
//			try {
//				Thread.sleep(2000);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
	//	}
	//	System.out.println("#### 生产者结束。。");
	}
	
	
}
