package commands;

import slogo_team02.State;
import model.Model;


public class Constant extends CommandZeroInputs{
	private double myValue;
	
	public Constant(double value) {
		myValue=value;
	}
	@Override
	public Double doCommand(Model model) {
		return myValue;
	}







}
