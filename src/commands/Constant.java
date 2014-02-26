package commands;

import model.Model;
import model.TurtleState;


public class Constant extends CommandZeroInputs{
	private double myValue;
	
	public Constant(double value) {
		myValue=value;
	}
	@Override
	public Double doCommand(TurtleState turtleState) {
		return myValue;
	}







}
