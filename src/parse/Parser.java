package parse;

import java.util.ArrayList;
import java.util.HashSet;
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
	private HashSet<Command> bracketCommands = new HashSet<Command>();
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
			Command c = getCommandType(token);
			commandList.add(c);
			if(token.type.toString().equals("INBRACKETS"))
				bracketCommands.add(c);
		}
		return commandList;
	}
	
	private Node buildTree(List<Command> commandList, Node n){
		
		Command root = commandList.get(0);
		commandList.remove(0);
		Node node = n;
		for(int i=0; i<root.myNumInputs; i++){
			node.addToChildrenList(commandList.get(0));
			buildTree(commandList,node.getLastChild());
		}
		
//		if(root instanceof CommandZeroInputs){
//			return node;
//		}
//		else if(root instanceof CommandOneInput){
//			node.addToChildrenList((commandList.get(0)));
//			buildTree(commandList,node.getChildrenList().get(0));
//			return node;
//		}
//		else if(root instanceof CommandTwoInputs){
//			
//			node.addToChildrenList((commandList.get(0)));
//			node.setRightChild(commandList.get(1));
//			commandList.remove(0); commandList.remove(0);
//			return node;
//		}
		
		if(root instanceof CommandList){
			node.addToChildrenList((commandList.get(0)));
			root.myNumInputs++;
			commandList.remove(0);			
			while(commandList.size()>0 && bracketCommands.contains(commandList.get(0))){
				node.addToChildrenList(commandList.get(0));
				root.myNumInputs++;
				buildTree(commandList,node.getChildrenList().get(node.getChildrenList().size()-1));
			}
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
	private boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	private Command getCommandType(Token token){
		if(isNumeric(token.data)){
			Command command = new Constant(Double.parseDouble(token.data));
			return command;
		}
		//All commands must be in the commands package
		
		try {
			Command command;	
			
			
			command = (Command) Class.forName("commands."+token.data).newInstance();
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
