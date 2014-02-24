package parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import parse.Lexer.Token;
import commands.Command;
import commands.CommandList;
import commands.CommandOneInput;
import commands.CommandTwoInputs;
import commands.CommandZeroInputs;
import commands.Constant;
/*
 * Takes raw input in string form, parses the information, and returns a list of trees with all of the commands
 */
public class Parser {
	private String myInput;
	private HashMap<Command,Token> myCommandTokenMap = new HashMap<Command,Token>();
	public Parser(String input) {
		myInput=input;
	}
	
	public List<Node> doParse(){
		List<Token> tokens= makeTokenList();
		
		List<Command> commandList = makeCommandList(tokens);
		
		List<Node> NodeList = new ArrayList<Node>();
		while(!commandList.isEmpty()){
			NodeList.add(buildTree(commandList,new Node(commandList.get(0))));
		}
		return NodeList;
	}
	
	private List<Command> makeCommandList(List<Token> tokens){
		List<Command> commandList = new ArrayList<Command>();
		
		for(Token token: tokens){
			
			commandList.add(getCommandType(token));
			myCommandTokenMap.put(getCommandType(token), token);
		}
		return commandList;
	}
	
	private Node buildTree(List<Command> commandList, Node n){
		
		Command root = commandList.get(0);
		commandList.remove(0);
		Node node = n;
		if(root instanceof CommandZeroInputs){
			return node;
		}
		else if(root instanceof CommandOneInput){
			node.setLeftChild(commandList.get(0));
			commandList.remove(0);
			return node;
		}
		else if(root instanceof CommandTwoInputs){
			
			node.setLeftChild(commandList.get(0));
			node.setRightChild(commandList.get(1));
			commandList.remove(0); commandList.remove(0);
			return node;
		}
		else if(root instanceof CommandList){
			node.setLeftChild(commandList.get(0));
			node.setRightChild(commandList.get(1));
			commandList.remove(0);
			buildTree(commandList,node.getRightChild());
			
		}
		return node;
		
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
			Command command;	
			if(token.data.startsWith("[")){
				command = (Command) Class.forName("commands."+token.data.substring(2,token.data.length()-2).trim()).newInstance();
			}
			
			else{command = (Command) Class.forName("commands."+token.data).newInstance();}
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
