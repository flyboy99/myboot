package com.lm.thread;

public class CountThread extends Thread{
	
	private int n;
	
	public CountThread(int n){
		this.n = n;
	}
	
	private double sum = 0.0;
	
	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	@Override
	public void run(){
		System.out.println(Thread.currentThread().getName()+ " 开始：  n=" + this.n);
		double s = getCount(this.n);
	//	setSum(s);
		sum += s;
		System.out.println(Thread.currentThread().getName()+ " 结束： n="+n + "  s="+getSum());
	}

	public static void main(String[] args) {
		//testGetCount();
		CountThread t1 = new CountThread(100);
		CountThread t2 = new CountThread(200);
		CountThread t3 = new CountThread(300);
		t1.start();
		t2.start();
		t3.start();
		/*double s1 = t1.getSum();
		double s2 = t2.getSum();
		double s3 = t3.getSum();*/
		double s1 = t1.getCount(100);
		double s2 = t2.getCount(200);
		double s3 = t3.getCount(300);
		double s = s1 + s2 + s3;
		System.out.println("s1=" + s1 +" s2="+ s2 +" s3="+ s3 +"  s=" + s);
	}
	
	public double getCount(int n){
		double sum = 0.0;
		for(int i=1; i<=n; i++){
			sum += Math.sqrt(i);
		}
		
		return sum;
	}
	
	public static void testGetCount(){
		int n = 10;
		CountThread test = new CountThread(n);
		
		for(int i=1; i<=n; i++){
			System.out.println(i+"  " + Math.round(test.getCount(i)));
		}
	}
}
