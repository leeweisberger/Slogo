package slogo_team02;

import parse.Parser;

public class Controller {
/*
 * The Controller class serves as a bridge between the View and the Model
 */
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	/*
	 * do Parse takes a String as an input, creates a new Lexer object, and passes the results of the lexer object to create a new Abstract Syntax Tree
	 */
	private void parse(String input){
		Parser parser = new Parser(input);
		parser.doParse();
	}

}
