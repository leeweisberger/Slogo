package parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import parse.Lexer.Token;
import commands.Command;
import commands.CommandList;
import commands.Constant;
import commands.IfElse;
import commands.Variable;
/*
 * Takes raw input in string form, parses the information, and returns a list of trees with all of the commands
 */
public class Parser {
	private String myInput;
	private Set<Command> trueBracketCommands = new HashSet<Command>();
	private Set<Command> falseBracketCommands = new HashSet<Command>();
	private Map<String,Variable> variableMap = new HashMap<String,Variable>();
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
				trueBracketCommands.add(curCommand);
			if(token.type.toString().equals("FALSE"))
				falseBracketCommands.add(curCommand);
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
		while(commandList.size()>0 && trueBracketCommands.contains(commandList.get(0))){
			node.addToChildrenList(commandList.get(0));
			((CommandList) root).incrementNumInputs();
			buildTree(commandList,node.getLastChild());
		}

		while(commandList.size()>0 && falseBracketCommands.contains(commandList.get(0))){
			node.addToFalseChildrenList(commandList.get(0));
			((CommandList) root).incrementNumFalseInputs();
			buildTree(commandList,node.getLastFalseChild());
		}

	}

	private Command getCommandType(Token token){
		if(isNumeric(token.data))
			return new Constant(Double.parseDouble(token.data));
		if(token.data.startsWith(":")){
			if(!variableMap.keySet().contains(token.data)){
				
				Variable var = new Variable(0);
				variableMap.put(token.data,var);
				return var;
			}
			return variableMap.get(token.data);

		}
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
