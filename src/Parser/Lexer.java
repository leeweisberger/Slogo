package Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Class Lexer receives a string input and converts this string to tokens
 */
public class Lexer {
	String myInput;
	public Lexer(String input){
		myInput=input;
	}
    private static enum TokenType {
        // Token types cannot have underscores
        CONSTANT("-?[0-9]+\\.?[0-9]*"), COMMAND("[a-zA-z_]+(\\?)?"), WHITESPACE("[ \t\f\r\n]+");

        public final String pattern;

        private TokenType(String pattern) {
            this.pattern = pattern;
        }
    }

    private static class Token {
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

    private static ArrayList<Token> lex(String input) {
        // The tokens to return
        ArrayList<Token> tokens = new ArrayList<Token>();

        // Lexer logic begins here
        StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (TokenType tokenType : TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

        // Begin matching tokens
        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            if (matcher.group(TokenType.CONSTANT.name()) != null) {
                tokens.add(new Token(TokenType.CONSTANT, matcher.group(TokenType.CONSTANT.name())));
                continue;
            } else if (matcher.group(TokenType.COMMAND.name()) != null) {
                tokens.add(new Token(TokenType.COMMAND, matcher.group(TokenType.COMMAND.name())));
                continue;
            } else if (matcher.group(TokenType.WHITESPACE.name()) != null)
                continue;
        }

        return tokens;
    }
    
    public List<Token> getTokens(){
    	List<Token> tokens = lex(myInput);
    	return tokens;
    }
    

//    public static void main(String[] args) {
//        String input = "fd 11.5 rt 45";
//
//        // Create tokens and print them
//        List<Token> tokens = lex(input);
//        for (Token token : tokens)
//            System.out.println(token);
//    }
}