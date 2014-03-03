package commands;

import java.util.List;

import model.Model;
import model.TurtleState;

public class Ask extends CommandList{
	
	

	@Override
	public Object doCommand(TurtleState turtleState) {
		List<Command> turtles = getInputs();
		for(int j=0; j<getNumInputs();j++){
			Double whichTurtled = (Double) getInputs().get(j).doCommand(turtleState);
			int whichTurtle = whichTurtled.intValue();
			System.out.println(whichTurtle);
			if(!Model.myStates.keySet().contains(whichTurtle)){
				Model.myStates.put(whichTurtle, new TurtleState(0,0,0));
			}
			TurtleState state = Model.myStates.get(whichTurtle);
			for(int i=0; i<this.getNumFalseInputs(); i++){
				getFalseInputs().get(i).doCommand(state);
			}
		}
		System.out.println("done");
		return null;
	}
	
	

}
