package commands;

import model.Model;
import slogo_team02.State;

/*
 * Abstract super class that defines a general Command
 */
public abstract class Command {
	public int myNumInputs;
	public Constant myInput1=null;
	public Constant myInput2=null;
	
	
	public int getNumInputs(){
		return myNumInputs;
	}
	public void setInput1(Constant input){
		myInput1=input;
	}
	public void setInput2(Constant input){
		myInput2=input;
	}
	public Constant[] getInputs(){
		return new Constant[] {myInput1,myInput2};
	}
	
	
	public abstract State doCommand(Model model);
}
