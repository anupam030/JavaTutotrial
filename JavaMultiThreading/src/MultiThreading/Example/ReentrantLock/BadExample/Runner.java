package MultiThreading.Example.ReentrantLock.BadExample;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private int count;
	
	private Lock lock= new ReentrantLock();
	
	private void increment (){
		for (int i =0;i<10000;i++) {
			count++;
		}
	}
	
	class Counter1 implements Runnable{

		@Override
		public void run() {
			increment();
			
		}
		
	}
	
	class Counter2 implements Runnable{

		@Override
		public void run() {
			increment();
			
		}
		
	}
	
	
	public void printCount() {
		System.out.println("Count is "+count);
	}

	public void runCounter1() {
		new Thread(new Counter1()).start();
	}
	
	public void runCounter2() {
		new Thread(new Counter2()).start();
	}
}
