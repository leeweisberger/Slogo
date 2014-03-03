package commands;

import java.util.List;

import model.Model;
import model.TurtleState;

public class Ask extends CommandList{
	
	@Override
	public Object doCommand(TurtleState turtleState) {
		for(int j=0; j<getNumInputs();j++){
			Double whichTurtled = (Double) getInputs().get(j).doCommand(turtleState);
			int whichTurtle = whichTurtled.intValue();
			if(!Model.myStates.keySet().contains(whichTurtle)){
				Model.myStates.put(whichTurtle, new TurtleState(0,0,0));
			}
			TurtleState state = Model.myStates.get(whichTurtle);
			for(int i=0; i<this.getNumFalseInputs(); i++){
				getFalseInputs().get(i).doCommand(state);
			}
		}
		return null;
	}
	
	

}
