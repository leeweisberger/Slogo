package parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	private HashMap<String,Boolean> isInBracketsMap = new HashMap<String,Boolean>();
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
			commandList.remove(0);
			System.out.println(myCommandTokenMap.get(commandList.get(0)).type);
			while(myCommandTokenMap.get(commandList.get(0)).type.equals("INBRACKETS")){
				node.addToChildrenList(commandList.get(0));			
			}
					
			buildTree(commandList,node.getChildrenList().get(node.getChildrenList().size()-1));
			
		}
		return node;
		
	}
	
	private List<Token> makeTokenList(){
		Lexer lexer = new Lexer();
		return lexer.lex(myInput);
	}
	
//	private HashMap<String,Boolean> isInBrackets(String input){
//		Pattern pattern = Pattern.compile("\\[(.*?)\\]");
//		Matcher matcher = pattern.matcher(input);
//		while(matcher.find()) {
//			isInBracketsMap.put(matcher.group(1), true);
//		    System.out.println(matcher.group(1));
//		}
//		return false;
//	}
	
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
