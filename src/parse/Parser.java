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
		Tree tree = makeTree(tokens);
		
	}
	private List<Token> makeTokenList(){
		Lexer lexer = new Lexer();
		return lexer.lex(myInput);
	}
	private Tree makeTree(List<Token> tokens){
		return new Tree(tokens);
	}
	
	

}
