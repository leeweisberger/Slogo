package commands;

import model.Model;
import slogo_team02.TurtleState;

public abstract class Direction extends CommandOneInput{
	
	public Double doCommand(TurtleState state){
		double degrees = Math.toRadians((double) getInput1().doCommand(state));
		state.setAngle(state.getAngle()+changeDirection(degrees));
		return changeDirection(degrees);
	}
	public  abstract double changeDirection(double degrees);

}
