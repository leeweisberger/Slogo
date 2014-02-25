package commands;

import model.Model;
import slogo_team02.State;

/*
 * Abstract super class that defines a general Command
 */
public abstract class Command {
	public int myNumInputs;
	public Command myInput1=null;
	public Command myInput2=null;
	
	
	public int getNumInputs(){
		return myNumInputs;
	}
	public void setInput1(Command command){
		myInput1=command;
		
	}
	public void setInput2(Command command){
		myInput2=command;
	}
	public abstract Command[] getInputs();
	
	
	public abstract Object doCommand(Model model);
}
