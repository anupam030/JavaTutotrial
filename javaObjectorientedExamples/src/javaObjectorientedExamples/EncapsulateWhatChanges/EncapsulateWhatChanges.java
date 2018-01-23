package javaObjectorientedExamples.EncapsulateWhatChanges;

public class EncapsulateWhatChanges {
	
//	If you are coding in Java then follow principle of making variable and methods private by default and increasing
//	access step by step e.g. from private to protected and not public.Factory design pattern is one example of Encapsulation which encapsulate object creation code and provides
//	flexibility to introduce new product later with no impact on existing code.
	
	private int variable;

	public int getVariable() {
		return variable;
	}

	public void setVariable(int variable) {
		this.variable = variable;
	}
	
	

}
