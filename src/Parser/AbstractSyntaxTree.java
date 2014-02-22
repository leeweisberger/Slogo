package Parser;

import java.util.List;

import Parser.Lexer.Token;

public class AbstractSyntaxTree {
	List<Token> myTokens;
	public AbstractSyntaxTree(List<Token> tokens) {
		myTokens=tokens;
	}

}
