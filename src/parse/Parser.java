package parse;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
	public Parser(String input) {
		myInput=input;
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

	private void addBracketCommands(List<Command> commandList, Command root,
			Node node) {		
		while(commandList.size()>0 && bracketCommands.contains(commandList.get(0))){
			node.addToChildrenList(commandList.get(0));
			((CommandList) root).incrementNumInputs();
			buildTree(commandList,node.getLastChild());
		}
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

}
