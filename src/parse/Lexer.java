package parse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Class Lexer receives a string input and converts this string to tokens
 */
public class Lexer {

	
	enum TokenType {
		// Token types cannot have underscores
		CONSTANT("-?[0-9]+\\.?[0-9]*"), COMMAND("[a-zA-z_]+(\\?)?"), WHITESPACE("[ \t\f\r\n]+"); 

		public final String pattern;
		//create new list of all of the types
		private static final List<TokenType> tokenTypes;
		static
		{
			tokenTypes = new ArrayList<TokenType>();
			tokenTypes.add(CONSTANT); tokenTypes.add(COMMAND); tokenTypes.add(WHITESPACE);
		}

		private TokenType(String pattern) {
			this.pattern = pattern;
		}
	}

	public static class Token {
		public TokenType type;
		public String data;

		public Token(TokenType type, String data) {
			this.type = type;
			this.data = data;
			
		}

//        @Override
//        public String toString() {
//            return String.format("(%s %s)", type.name(), data);
//        }
	}

	public  List<Token> lex(String input) {
		// The tokens to return
		List<Token> tokens = new ArrayList<Token>();

		// Lexer logic begins here
		StringBuffer tokenPatternsBuffer = new StringBuffer();
		for (TokenType tokenType : TokenType.values())
			tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
		Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

		// Begin matching tokens
		Matcher matcher = tokenPatterns.matcher(input);
		while (matcher.find()) {
			tokens=matchTokenTypes(tokens, matcher);
		}

		return tokens;
	}


	private List<Token> matchTokenTypes(List<Token> tokens, Matcher matcher) {
		for(TokenType token:TokenType.tokenTypes){
			if (matcher.group(TokenType.WHITESPACE.name()) != null){
				//do nothing
			}
			else if(matcher.group(token.name())!=null){
				tokens.add(new Token(token, matcher.group(token.name())));
				
			}
			
		}
		return tokens;
	}





//	    public static void main(String[] args) {
//	        String input = "fd 11.5 + rt 45";
//	
//	        // Create tokens and print them
//	        List<Token> tokens = lex(input);
//	        for (Token token : tokens)
//	            System.out.println(token);
//	    }
}