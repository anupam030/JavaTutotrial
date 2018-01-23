package javaObjectorientedExamples.DependencyInversionPrinciple;

//https://www.codeproject.com/Articles/615139/An-Absolute-Beginners-Tutorial-on-Dependency-Inver

public class AppPoolWatcher
{
    // Handle to EventLog writer to write to the logs
    INofificationAction action = null;

/*    Constructor Injection
    public AppPoolWatcher(INofificationAction concreteImplementation)
    {
        this.action = concreteImplementation;
    }*/

  /*  Method Injection
    // This function will be called when the app pool has problem
    public void Notify(INofificationAction concreteAction, String message)
    {
        this.action = concreteAction;
        action.ActOnNotification(message);
    }*/
  
    //Property Injection
    public INofificationAction getAction() {
		return action;
	}

	public void setAction(INofificationAction action) {
		this.action = action;
	}

	// This function will be called when the app pool has problem
    public void Notify(String message)
    {   
        action.ActOnNotification(message);
    }
}