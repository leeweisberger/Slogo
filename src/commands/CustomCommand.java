package commands;

import model.TurtleState;

public class CustomCommand extends CommandList{
	private String myName;
	public CustomCommand(String name) {
		myName=name;
		this.setNumInputs(0);
		
	}

	@Override
	public Object doCommand(TurtleState turtleState) {
		System.out.println(this.getInputs());		
		return null;
	}
	public String getName(){
		return myName;
	}

}
