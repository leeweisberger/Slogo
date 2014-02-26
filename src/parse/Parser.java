package parse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;

import parse.Lexer.Token;
import commands.Command;
import commands.CommandList;
import commands.Constant;
/*
 * Takes raw input in string form, parses the information, and returns a list of trees with all of the commands
 */
public class Parser {
	private String myInput;
	private HashSet<Command> bracketCommands = new HashSet<Command>();
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	ResourceBundle myResources; 
	
	public Parser(String input, String language) {
		myInput=input;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE + language);
		
	}

	public List<Node> parseToNodeList(){
		List<Token> tokens= makeTokenList();	
		List<Command> commandList = makeCommandList(tokens);
		List<Node> NodeList = new ArrayList<Node>();
		while(!commandList.isEmpty()){
			NodeList.add(buildTree(commandList,new Node(commandList.get(0))));
		}
		return NodeList;
	}

	private List<Token> makeTokenList(){
		Lexer lexer = new Lexer();
		return lexer.lex(myInput);
	}

	private List<Command> makeCommandList(List<Token> tokens){
		List<Command> commandList = new ArrayList<Command>();	
		for(Token token: tokens){
			Command curCommand = getCommandType(token);
			commandList.add(curCommand);
			if(token.type.toString().equals("INBRACKETS"))
				bracketCommands.add(curCommand);
		}
		return commandList;
	}

	private Node buildTree(List<Command> commandList, Node n){	
		Command root = commandList.get(0);
		commandList.remove(0);
		Node node = n;
		for(int i=0; i<root.getNumInputs(); i++){
			node.addToChildrenList(commandList.get(0));
			buildTree(commandList,node.getLastChild());
		}
		if(root instanceof CommandList){
			addBracketCommands(commandList, root, node);
		}
		return node;	
	}

	private void addBracketCommands(List<Command> commandList, Command root,Node node) {		
		while(commandList.size()>0 && bracketCommands.contains(commandList.get(0))){
			node.addToChildrenList(commandList.get(0));
			((CommandList) root).incrementNumInputs();
			buildTree(commandList,node.getLastChild());
		}
	}

	private Command getCommandType(Token token){
		if(isNumeric(token.data))
			return new Constant(Double.parseDouble(token.data));
		//All commands must be in the commands package
		try {	
			token.data = myResources.getString(token.data.toLowerCase());
			return (Command) Class.forName("commands."+token.data).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	private boolean isNumeric(String str){  
		try{ Double.parseDouble(str);  } 
		catch(NumberFormatException nfe){return false;}  
		return true;  
	}

}
