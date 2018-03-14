package MultiThreading.Example.ReentrantLock.BadExample;

public class MainRunner {

	public static void main(String[] args) {
		Runner runner = new Runner();
		Thread t1 = new Thread(runner.new Counter1());
		Thread t2 = new Thread(runner.new Counter2());
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   runner.printCount();

	}

}
