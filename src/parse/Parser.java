package parse;

import java.util.List;

import parse.Lexer.Token;

public class Parser {
	private String myInput;
	public Parser(String input) {
		myInput=input;
	}
	
	public void doParse(){
		List<Token> tokens= makeTokenList();
	}
	private List<Token> makeTokenList(){
		Lexer lexer = new Lexer();
		List<Token> tokens = lexer.lex(myInput);
		return tokens;
	}
	private void makeTree(List<Token> tokens){
		Tree tree = new Tree(tokens);
	}
	
	

}
