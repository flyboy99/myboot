package com.myspring.tt.myboot.thread;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test1 {

	public static void main(String[] args) {
		String[] words = {"aaa","bbbb","hello"};
		
		ExecutorService pool = Executors.newCachedThreadPool();
		Set<Future<Integer>> set = new HashSet<Future<Integer>>();
		
		for(String word : words){
			Callable<Integer> callable = new testCallable(word);
			Future<Integer> future = pool.submit(callable);
			set.add(future);
		}
		// show set
		int sum = 0;
		for(Future<Integer> f : set){
			try {
				sum += f.get();
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		System.out.println("总长度为： " + sum );
	}

}
