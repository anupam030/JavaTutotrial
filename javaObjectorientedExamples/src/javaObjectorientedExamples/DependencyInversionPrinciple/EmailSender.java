package javaObjectorientedExamples.DependencyInversionPrinciple;

public class EmailSender implements INofificationAction
{
    public void ActOnNotification(String message)
    {
        // Send email from here
    	System.out.println("Sending Email");
    }
}