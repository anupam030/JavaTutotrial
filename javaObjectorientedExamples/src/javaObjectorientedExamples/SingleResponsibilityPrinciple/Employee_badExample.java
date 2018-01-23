package javaObjectorientedExamples.SingleResponsibilityPrinciple;

import java.util.Date;

public class Employee_badExample{
  private String employeeId;
  private String name;
  private String address; 
  private Date dateOfJoining;
  public boolean isPromotionDueThisYear(){
	return false;
    //promotion logic implementation
  }
  public Double calcIncomeTaxForCurrentYear(){
	return null;
    //income tax logic implementation
  }
  //Getters & Setters for all the private attributes
}