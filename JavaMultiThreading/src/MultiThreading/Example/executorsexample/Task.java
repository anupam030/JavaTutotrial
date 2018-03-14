package MultiThreading.Example.executorsexample;
public class Task implements Runnable {

    private int num;

    public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Task(int n) {
        num = n;
    }

    public void run() {
        System.out.println("Task " + num + " is running.");
    }
}