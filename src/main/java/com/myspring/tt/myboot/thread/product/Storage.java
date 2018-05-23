package com.myspring.tt.myboot.thread.product;

import java.util.LinkedList;

public class Storage {
	private final int MAX_SIZE = 10;
		
	private LinkedList<Car> list = new LinkedList<Car>();
	
	//produce car
	public void produce(String name,String produce){
		synchronized (list) {
			System.out.println("线程名称开始进入"+ produce);
			while(list.size()==MAX_SIZE){
				System.out.println("空间已经满，不能生产。。。。当前线程id："+ Thread.currentThread().getId()+" name="+ Thread.currentThread().getName());
				try {
					list.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			list.add(new Car(name));
			System.out.println(produce+" 生产完成，空间为：" + list.size());
			list.notifyAll();
		}
	}
	
	//consume
	public void consume(String consume){
		synchronized (list) {
			System.out.println("消费者开始工作 " + consume);
			while(list.size()==0){
				try {
					list.wait();
					System.out.println(consume+" 等待中，当前线程 " +
					Thread.currentThread().getId()+" "+ Thread.currentThread().getName());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			Car car = list.remove();
			System.out.println("消费的car ： " + car);
			list.notifyAll();
			System.out.println(consume+ "离开，空间为： " + list.size());
		}
	}
}
