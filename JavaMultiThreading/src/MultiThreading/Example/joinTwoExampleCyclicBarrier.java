package MultiThreading.Example;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
class joinTwoExampleCyclicBarrier{
	
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(3);
		
            Thread T1 = new Thread (new Runnable() {
			
			@Override
			public void run() {
			    System.out.println("Thread "+Thread.currentThread().getName());
			    try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		    Thread T2 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("Thread "+Thread.currentThread().getName());
				
			}
		});
		
		    Thread T3 = new Thread (new Runnable() {
			
			@Override
			public void run() {
				try {
					cb.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			    System.out.println("Thread "+Thread.currentThread().getName());
			    
				
			}
		});
		
		
	}
	
}