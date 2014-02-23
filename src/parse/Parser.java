package parse;

import java.util.ArrayList;
import java.util.List;

import parse.Lexer.Token;

import commands.Command;
import commands.turtle.Constant;
import parse.Forward;
public class Parser {
	private String myInput;
	public Parser(String input) {
		myInput=input;
	}
	
	public void doParse(){
		List<Token> tokens= makeTokenList();
		List<Command> commandList = makeCommandList(tokens);
		
		Tree tree = makeTree(tokens);
		
	}
	
	private List<Command> makeCommandList(List<Token> tokens){
		List<Command> commandList = new ArrayList<Command>();
		for(Token token: tokens){
			commandList.add(getCommandType(token));
		}
		return commandList;
	}
	
	private List<Token> makeTokenList(){
		Lexer lexer = new Lexer();
		return lexer.lex(myInput);
	}
	private Tree makeTree(List<Token> tokens){
		return new Tree(tokens);
	}
	
	private Command getCommandType(Token token){
		if(token.type.name().equals("CONSTANT")){
			Command command = new Constant();
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
