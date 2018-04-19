package javaObjectorientedExamples.DependencyInversionPrinciple;

//https://www.codeproject.com/Articles/615139/An-Absolute-Beginners-Tutorial-on-Dependency-Inver


/*Dependency inversion principle is a software design principle which provides us the guidelines to write loosely coupled classes.
According to the definition of Dependency inversion principle:

High-level modules should not depend on low-level modules. Both should depend on abstractions.
Abstractions should not depend upon details. Details should depend upon abstractions.*/

/*Inversion of control is the actual mechanism using which we can make the higher level modules to depend on abstractions rather 
than concrete implementation of lower level modules.*/

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