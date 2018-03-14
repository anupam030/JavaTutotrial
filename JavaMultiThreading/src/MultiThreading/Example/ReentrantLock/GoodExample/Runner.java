package MultiThreading.Example.ReentrantLock.GoodExample;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {

	private int count;

	private Lock lock= new ReentrantLock();
	
	private Condition condition =  lock.newCondition();

	private void increment (){
		for (int i =0;i<10000;i++) {
			count++;
		}
	}

	class Counter1 implements Runnable{

		@Override
		public void run() {
			lock.lock();
			System.out.println("Counter 1 waiting");
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Counter 1 woke up");
			try{
				increment();
			} finally {
				lock.unlock(); // we should do this in case ncrement throws exception this way we will make sure to release the lock if
				               // exception is thrown // it will always be called
			}
		}

	}

	class Counter2 implements Runnable{

		@Override
		public void run() {
			
			try {
				Thread.sleep(1000);//so that counter1 will wake first
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
			lock.lock();
			condition.signal();
			System.out.println("Counter 2 signalled counter 1");
			try{
				increment();
			} finally {
				lock.unlock(); // we should do this in case ncrement throws exception this way we will make sure to release the lock if
				               // exception is thrown // it will always be called
			}

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
