package javaObjectorientedExamples.DependencyInversionPrinciple;

public class SMSSender implements INofificationAction
{
    public void ActOnNotification(String message)
    {
        // Send SMS from here
    }
}