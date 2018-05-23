package com.lm.thread;
/**
 *现在有T1、T2、T3三个线程，你怎样保证T2在T1执行完后执行，T3在T2执行完后执行？
 * 
 */
public class JoinTest {
	
	/**
	 * thread.Join把指定的线程加入到当前线程，可以将两个交替执行的线程合并为顺序执行的线程。 
		比如在线程B中调用了线程A的Join()方法，直到线程A执行完毕后，才会继续执行线程B。 
		想要更深入了解，建议看一下join的源码，也很简单的，使用wait方法实现的。
		
		t.join(); //调用join方法，等待线程t执行完毕 
		t.join(1000); //等待 t 线程，等待时间是1000毫秒。
	 */
	private static void method1(){
		final Thread t1 = new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("t1 is running.....");
			}
			
		});
		final Thread t2 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				try {
					t1.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t2 is running.....");
			}
			
		});
		Thread t3 = new Thread(new Runnable(){
			
			@Override
			public void run() {
				try {
					t2.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("t3 is running.....");
			}
			
		});
		t1.start();
		t2.start();
		t3.start();
	}
	
	private static void test1(){
		method1();
	}
	
	public static void main(String[] args) {
		//test1();
		method2();
	}
	
	private static void method2(){
		Runnable runnable = new Runnable(){
		    @Override
		    public void run(){
		    	System.out.println(Thread.currentThread().getName() +" is running...");
		    }
		};
		
		Thread t1 = new Thread(runnable,"t1");
		Thread t2 = new Thread(runnable,"t2");
		Thread t3 = new Thread(runnable,"t3");
		
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
			t3.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
