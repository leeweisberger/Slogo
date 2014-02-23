package parse;

import java.util.ArrayList;
import java.util.List;

import parse.Lexer.Token;
import commands.Command;
import commands.CommandOneInput;
import commands.CommandTwoInputs;
import commands.CommandZeroInputs;
import commands.Constant;
import commands.Forward;
/*
 * Takes raw input in string form, parses the information, and returns a list of trees with all of the commands
 */
public class Parser {
	private String myInput;
	public Parser(String input) {
		myInput=input;
	}
	
	public List<Node> doParse(){
		List<Token> tokens= makeTokenList();
		List<Command> commandList = makeCommandList(tokens);
		
		List<Node> NodeList = new ArrayList<Node>();
		while(!commandList.isEmpty()){
			NodeList.add(buildTree(commandList));
		}
		return NodeList;
	}
	
	private List<Command> makeCommandList(List<Token> tokens){
		List<Command> commandList = new ArrayList<Command>();
		for(Token token: tokens){
			commandList.add(getCommandType(token));
		}
		return commandList;
	}
	
	private Node buildTree(List<Command> commandList){
		
		Command root = commandList.get(0);
		commandList.remove(0);
		Node Node = new Node(root);
		if(root instanceof CommandZeroInputs){
			return Node;
		}
		if(root instanceof CommandOneInput){
			Node.setLeftChild(commandList.get(0));
			commandList.remove(0);
			return Node;
		}
		else if(root instanceof CommandTwoInputs){
			Node.setLeftChild(commandList.get(0));
			Node.setRightChild(commandList.get(1));
			commandList.remove(0); commandList.remove(0);
			return Node;
		}
		return Node;
		
	}
	
	private List<Token> makeTokenList(){
		Lexer lexer = new Lexer();
		return lexer.lex(myInput);
	}
	
	
	private Command getCommandType(Token token){
		if(token.type.name().equals("CONSTANT")){
			Command command = new Constant(Double.parseDouble(token.data));
			return command;
		}
		//All commands must be in the commands package
		try {
			Command command = (Command) Class.forName("commands."+token.data).newInstance();
			return command;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}

}
