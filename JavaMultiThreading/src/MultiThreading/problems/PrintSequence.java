package MultiThreading.problems;

public class PrintSequence {

	public Object lock=new Object();

	static  boolean thread1= true;
	static  boolean thread2=false;
	static  boolean thread3=false;


	public static void main(String args[]) {
		PrintSequence ps = new PrintSequence();
		new Thread(ps.new Printer1()).start();
		new Thread(ps.new Printer2()).start();
		new Thread(ps.new Printer3()).start();
	}


	class Printer1 implements Runnable{

		@Override
		public void run() {
			int i =1;
			while(true) {
				synchronized(lock) {
					if (thread1) {
						System.out.print(i+" ");
						i++;
						thread2=true;
						thread1 = false;
						thread3 = false;
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


	class Printer2 implements Runnable{

		@Override
		public void run() {
			int i =1;
			while(true) {
				synchronized(lock) {
					if (thread2) {
						System.out.print(i+" ");
						i++;
						thread3=true;
						thread2= false;
						thread1 = false;
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


	class Printer3 implements Runnable{

		@Override
		public void run() {
			int i =1;
			while(true) {
				synchronized(lock) {	
					if (thread3) {
						System.out.println(i);
						i++;
						thread1=true;
						thread3= false;
						thread2 = false;
						lock.notifyAll();
						//lock.notify(); this will cause a problem as it may gave access to the lock which for which boolean is false
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
