package com.myspring.tt.myboot.thread;

import java.util.concurrent.Callable;

public class testCallable implements Callable<Integer> {
   private String word;
   
   public testCallable(String word){
	   this.word = word;
   }
   
   
		
	@Override
	public Integer call() throws Exception {
		System.out.println("线程开始跑，线程名称。。。"+ Thread.currentThread().getName());
		try{
			Thread.sleep(1000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("字符串 " + word +" 长度为: " + word.length());
		return Integer.valueOf(word.length());
	}

}
