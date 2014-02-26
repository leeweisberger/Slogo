package slogo_team02;

import java.util.ResourceBundle;

import javax.swing.JFrame;

import commands.Command;
import model.Model;
import parse.Node;
import view.Display;

public class Controller {
	/*
	 * The Controller class serves as a bridge between the View and the Model
	 */
	private static final String TITLE = "SLogo";
	 
	private void doModel(String input){
		Model model = new Model();		
		model.setState(0, 0, 0);
		model.doCommands(input);	
	}
	
	private void doView(){
		Display display = new Display(); 
		JFrame frame = new JFrame(TITLE); 
	}
	
	//main method to test
	public static void main(String[] args) {
		Controller c = new Controller();

		c.doView();
		c.doModel("rePEat 5 [ fd sum 4 sum 4 5 ]");

	}


}
