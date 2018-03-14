package MultiThreading.Example.executorsexample;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*http://codetheory.in/android-java-executor-framework/
*/
public class ThreadPool {

	private int nThreads;
	private  Set<PoolWorker> threads;

	private BlockingQueue<Runnable> queue;


	public ThreadPool(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedBlockingQueue<Runnable>();
		threads = new HashSet<PoolWorker>();

		for (int i = 0; i < this.nThreads; i++) {
			PoolWorker poolWorker = new PoolWorker(i);
			threads.add(poolWorker);
			poolWorker.start();
		}
	}
	public void execute(Runnable task) {
		queue.add(task);
	}


	private class PoolWorker extends Thread {
		Task task;
		int priority;

		PoolWorker(int priority){
			this.priority= priority;

		}

		@Override
		public void run() {

			while (true) {

				task = (Task) queue.peek();
				if(task!=null && task.getNum()== this.priority) {
					task.run();
					queue.poll();
				}
			}
		}

	}
}
