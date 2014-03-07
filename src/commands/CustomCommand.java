package commands;

import java.util.ArrayList;
import java.util.List;

import commands.basic.Command;
import commands.basic.CommandList;
import commands.basic.Variable;

import model.TurtleState;

/**
 * The Class CustomCommand.
 */
public class CustomCommand extends CommandList{
	
	/** The variables. */
	private List<Command> myVariables = new ArrayList<Command>();
	
	/** The commands. */
	private List<Command> myCommands = new ArrayList<Command>();
	
	/** The name. */
	private String myName;
	
	/**
	 * Instantiates a new custom command.
	 *
	 * @param name the name of the command
	 */
	public CustomCommand(String name) {
		myName=name;
		this.setNumInputs(0);
	}

	/* (non-Javadoc)
	 * @see commands.basic.Command#doCommand(model.TurtleState)
	 */
	@Override
	public Object doCommand(TurtleState turtleState) {
		for(int i=0;i<myVariables.size();i++){
			((Variable)myVariables.get(i)).setValue((double) getInputs().get(i).doCommand(turtleState));
		}
		for(int i=0; i<getNumFalseInputs(); i++){
			//recursion
			if(myCommands.get(i) instanceof CustomCommand){
				((CustomCommand) myCommands.get(i)).saveCommand(myVariables, myCommands);
				myCommands.get(i).setInputs((ArrayList<Command>) ((CommandList) myCommands.get(i)).getFalseInputs());
				((CommandList) myCommands.get(i)).setNumFalseInputs(this.getNumFalseInputs());
				
			}
			myCommands.get(i).doCommand(turtleState);
		}
		//clearInputs();
		return null;
	}
	
	/**
	 * Gets the name.
	 *
	 * @return the name of the command
	 */
	public String getName(){
		return myName;
	}
	
	/**
	 * Save command.
	 *
	 * @param variables the variables of the command
	 * @param commands the commands of the custom command
	 */
	public void saveCommand(List<Command> variables, List<Command> commands){
		clearInputs();
		myVariables=variables;
		myCommands = commands;
		
	}

}
