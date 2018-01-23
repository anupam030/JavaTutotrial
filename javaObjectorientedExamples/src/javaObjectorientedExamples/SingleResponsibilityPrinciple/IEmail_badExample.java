package javaObjectorientedExamples.SingleResponsibilityPrinciple;
// single responsibility principle - bad example

/*This principle states that if we have 2 reasons to change for a class, we have to split the functionality in two classes. 
Each class will handle only one responsibility and if in the future we need to make one change we are going to make it in 
the class which handles it. When we need to make a change in a class having more responsibilities
the change might affect the other functionality related to the other responsibility of the class.*/

/*If we keep only one class, each change for a responsibility might affect the other one:

Adding a new protocol will create the need to add code for parsing and serializing the content for each type of field.
Adding a new content type (like html) make us to add code for each protocol implemented.*/
interface IEmail_badExample {
	public void setSender(String sender);
	public void setReceiver(String receiver);
	public void setContent(String content);
}

class Email implements IEmail_badExample {
	public void setSender(String sender) {// set sender; 

	}
	public void setReceiver(String receiver) {// set receiver; 
	}

	public void setContent(String content) {// set content; 

	}
}
