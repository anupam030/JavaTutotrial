package MultiThreading.problems;

public class PrintOddEven {

	public Object lock=new Object();

	static  boolean even = false;
	static  boolean odd = true;


	public static void main(String args[]) {
		PrintOddEven ps = new PrintOddEven();
		new Thread(ps.new PrinterEven()).start();
		new Thread(ps.new PrinterOdd()).start();
	}


	class PrinterEven implements Runnable{

		@Override
		public void run() {
			int i =2;
			while(true) {
				synchronized(lock) {
					if (even) {
						System.out.println(i);
						i=i+2;
						even = false;
						odd = true;
						lock.notifyAll();
						//lock.notify(); this will cause a problem
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}

	}


	class PrinterOdd implements Runnable{

		@Override
		public void run() {
			int i =1;
			while(true) {
				synchronized(lock) {
					if (odd) {
						System.out.print(i+" ");
					    i=i+2;
						odd=false;
						even= true;
						lock.notifyAll();
						//lock.notify(); this will cause a problem
					} else {
						try {
							lock.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
		}

	}

}
