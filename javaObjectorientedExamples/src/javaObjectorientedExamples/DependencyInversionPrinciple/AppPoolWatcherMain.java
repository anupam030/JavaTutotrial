package javaObjectorientedExamples.DependencyInversionPrinciple;

public class AppPoolWatcherMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*EventLogWriter writer = new EventLogWriter();
		//Constructor Injection
		AppPoolWatcher watcher = new AppPoolWatcher(writer);
		watcher.Notify("Sample message to log");
		*/
		
		/*EventLogWriter writer = new EventLogWriter();
		//Property Injection
		AppPoolWatcher watcher = new AppPoolWatcher();
		watcher.Notify(writer, "Sample message to log");*/
		
		EventLogWriter writer = new EventLogWriter();
		AppPoolWatcher watcher = new AppPoolWatcher();
		// This can be done in some class
		watcher.setAction(writer);

		// This can be done in some other class
		watcher.Notify("Sample message to log");
	}

}
