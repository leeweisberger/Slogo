package commands;

import java.util.ArrayList;
import java.util.List;

import commands.basic.Command;
import commands.basic.CommandList;
import commands.basic.Variable;

import model.TurtleState;

public class CustomCommand extends CommandList{
	private List<Command> myVariables = new ArrayList<Command>();
	private List<Command> myCommands = new ArrayList<Command>();
	private String myName;
	public CustomCommand(String name) {
		myName=name;
		this.setNumInputs(0);
	}

	@Override
	public Object doCommand(TurtleState turtleState) {
		for(int i=0;i<myVariables.size();i++){
			((Variable)myVariables.get(i)).setValue((double) getInputs().get(i).doCommand(turtleState));
		}
		for(int i=0; i<getNumFalseInputs(); i++){
			
			myCommands.get(i).doCommand(turtleState);
		}
		clearInputs();
		return null;
	}
	public String getName(){
		return myName;
	}
	public void saveCommand(List<Command> variables, List<Command> commands){
		clearInputs();
		myVariables=variables;
		myCommands = commands;
		
	}

}
