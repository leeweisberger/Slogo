package commands;

import java.util.ArrayList;
import java.util.List;

import model.Model;

/*
 * Abstract super class that defines a general Command
 */
public abstract class Command {
	private int myNumInputs;
	private List<Command> myInputs = new ArrayList<Command>();

	public int getNumInputs(){
		return myNumInputs;
	}
	
	public void setNumInputs(int numInputs){
		myNumInputs = numInputs;
	}
	
	public void addInput(Command command){
		myInputs.add(command);
	}
	public List<Command> getInputs(){
		return myInputs;
	}
	
	public abstract Object doCommand(Model model);
}
