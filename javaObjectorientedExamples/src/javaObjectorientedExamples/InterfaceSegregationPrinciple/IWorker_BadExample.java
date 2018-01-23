package javaObjectorientedExamples.InterfaceSegregationPrinciple;

/*The Interface Segregation Principle states that clients should not be forced to implement interfaces they don't use. 
Instead of one fat interface many small interfaces are preferred based on groups of methods, each one serving one submodule.*/
// interface segregation principle - bad example
interface IWorker_BadExample {
	public void work();
	public void eat();
}

class Worker implements IWorker_BadExample{
	public void work() {
		// ....working
	}
	public void eat() {
		// ...... eating in launch break
	}
}

class SuperWorker implements IWorker_BadExample{
	public void work() {
		//.... working much more
	}

	public void eat() {
		//.... eating in launch break
	}
}

class Manager {
	IWorker_BadExample worker;

	public void setWorker(IWorker_BadExample w) {
		worker=w;
	}

	public void manage() {
		worker.work();
	}
}
