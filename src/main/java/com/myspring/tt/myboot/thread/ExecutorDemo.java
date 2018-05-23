package com.myspring.tt.myboot.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorDemo {
	private final static int max = 10;
	
	public static void main(String[] args) {
		System.out.println("main begin: ");
		long start = System.currentTimeMillis();
		fixedThreadPool(4);
		long end = System.currentTimeMillis();
		System.out.println("fixed cost time " + (end-start));
		
		 start = System.currentTimeMillis();
		 cachedThreadPool();
		 end = System.currentTimeMillis();
		System.out.println("cached cost time " + (end-start));
	}
	
	private static void cachedThreadPool(){
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<max;i++){
			exec.submit(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName()+"  " +fibc(20));
					
				}
			});
		}
	}
	
	private static void fixedThreadPool(int coresize){
		ExecutorService exec = Executors.newFixedThreadPool(coresize);
		for(int i=0;i<max;i++){
			Future<Integer> task = exec.submit(new Callable<Integer>(){

				@Override
				public Integer call() throws Exception {
					System.out.println(Thread.currentThread().getName());
					return fibc(20);
				}
				
			});
			try {
				System.out.println(task.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static int fibc(int num){
		if(num==0){
			return 0;
		}
		if(num==1){
			return 1;
		}
		return fibc(num-1)+fibc(num-2);
	}
}
