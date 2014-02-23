package parse;

import java.util.ArrayList;
import java.util.List;

import parse.Lexer.Token;
import commands.Command;
import commands.CommandOneInput;
import commands.CommandTwoInputs;
import commands.CommandZeroInputs;
import commands.Forward;
import commands.turtle.Constant;
public class Parser {
	private String myInput;
	public Parser(String input) {
		myInput=input;
	}
	
	public void doParse(){
		List<Token> tokens= makeTokenList();
		List<Command> commandList = makeCommandList(tokens);
		
		List<Node> NodeList = new ArrayList<Node>();
		while(!commandList.isEmpty()){
			NodeList.add(buildTree(commandList));
		}
		
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
			Command command = new Constant();
			return command;
		}
		//This is added because the try statement is not working. So the only command that will be recognized is Forward for now
		if(token.data.equals("Forward")){
			Command command = new Forward();
			return command;
		}
		try {
			Command command = (Command) Class.forName(token.data).newInstance();
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
	
	public static void main(String[] args) {
		Parser p = new Parser("Forward 50");
		p.doParse();
	}
	
	
	
	
	

}
