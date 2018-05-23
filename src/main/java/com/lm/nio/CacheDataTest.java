package com.lm.nio;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class CacheDataTest {
	private static Map<Integer,Object> datamap = new HashMap<Integer,Object>();
	
	public static ReadWriteLock lock = new ReentrantReadWriteLock();
	public static Object getData(Integer key){
		lock.readLock().lock();
		Object val = null;
		try{
			val = datamap.get(key);
			if(null == val){
				lock.readLock().unlock();
				lock.writeLock().lock();
				try{
					if(null==val){
						val = queryData(key);
					}
				}finally{
					lock.readLock().lock();
					lock.writeLock().unlock();
				}
			}
		}finally{
			lock.readLock().unlock();
		}
	//	System.out.println(Thread.currentThread().getName() + " -- key="+ key +" val="+val);
		return val;
	}
	
	public static Object queryData(Integer key){
		Object val = new Random().nextInt(1000);
		datamap.put(key, val);
		System.out.println(Thread.currentThread().getName()+" write into data key="+ key +" val="+val);
		return val;
	}
	
	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			new Thread(new Runnable(){
				public void run(){
					getData(new Random().nextInt(10));
				}
			}).start();
		}
	}

}
