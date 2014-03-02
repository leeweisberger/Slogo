package slogo_team02;

import java.io.Console;
import java.util.Scanner;

import model.Model;


public class Controller {
	/*
	 * The Controller class serves as a bridge between the View and the Model
	 */


	public void doModel(String input, Model model){	
		model.doCommands(input);	
	}
	public void go(Model model){
		while(true){
			Scanner scanner = new Scanner (System.in);
			String input = scanner.nextLine();
			doModel(input,model);
		}
	}


}



