package commands;

import model.Model;
import model.TurtleState;

public class Tell extends CommandList{

	@Override
	public Object doCommand(TurtleState turtleState) {
		Model.activeTurtles.clear();
		for(int i=0;i<this.getNumInputs();i++){
			int turtle = ((Double) getInputs().get(i).doCommand(turtleState)).intValue();
		
			if(!Model.myStates.keySet().contains(turtle)){
				Model.setState(0, 0, 0, turtle);
			}
			else{Model.activeTurtles.add(turtle);}
		}
		return null;
	}

}
