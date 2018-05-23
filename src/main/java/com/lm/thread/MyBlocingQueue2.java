package com.lm.thread;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlocingQueue2<E> {
	private final List list;
    private final int limit;//有大小限制的
    private final Lock lock = new ReentrantLock();
    private final Condition notFull = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    public MyBlocingQueue2(int limit) {
        this.limit = limit;
        this.list = new LinkedList<E>();
    }

    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == limit){
                notFull.await();
            }
            list.add(e);
            notEmpty.signalAll();
            System.out.println(Thread.currentThread().getId() +" put " + e +" list " + list.toString());
        }finally {
            lock.unlock();
        }
    }
    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (list.size() == 0){
                notEmpty.await();
            }
            E remove = (E) list.remove(0);
            notFull.signalAll();
            System.out.println(Thread.currentThread().getId()+" take " + remove +" list: " + list.toString());
            return remove;
        }finally {
            lock.unlock();
        }
    }
    /********************    下面是测试区       *********************************/
    public static void main(String[] args) {
        final MyBlocingQueue2<Integer> myBlocingQueue = new MyBlocingQueue2(10);
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            exec.execute(new TestRunnable(myBlocingQueue));
        }
        exec.shutdown();
    }

    static class TestRunnable implements Runnable{
        private final MyBlocingQueue2<Integer> myBlocingQueue;

        TestRunnable(MyBlocingQueue2<Integer> myBlocingQueue) {
            this.myBlocingQueue = myBlocingQueue;
        }

        @Override
        public void run() {
            Random random = new Random();
            int r = random.nextInt(100);
            //生成随机数,按照一定比率读取或者放入，可以更改！！！
            try {
	            if (r < 30){                
					myBlocingQueue.put(r);				
	            } else {
	                myBlocingQueue.take();
	            }
            } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}