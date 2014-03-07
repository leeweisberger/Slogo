package parse;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/*
 * Class Lexer receives a string input and converts this string to tokens
 */
public class Lexer {
    boolean isFalse = false;

    enum TokenType {
        CONSTANT("-?[0-9]+\\.?[0-9]*"), VARIABLE(":[a-zA-z]+"), INBRACKETS("\\[(.*?)\\]"),  
        COMMAND("[a-zA-z_]+(\\?)?"),  WHITESPACE("[ \t\f\r\n]+"), FALSE(""); 

        public final String pattern;
        private static final List<TokenType> tokenTypes;
        static
        {
            tokenTypes = new ArrayList<TokenType>();		
            tokenTypes.add(CONSTANT); tokenTypes.add(VARIABLE); tokenTypes.add(COMMAND);  tokenTypes.add(WHITESPACE);tokenTypes.add(INBRACKETS);  
        }

        private TokenType(String pattern) {
            this.pattern = pattern;
        }
    }

    public class Token {
        public TokenType type;
        public String data;

        public Token(TokenType type, String data) {
            this.type = type;
            this.data = data;			
        }
    }

    public List<Token> lex(String input) {
        // The tokens to return
        List<Token> tokens = new ArrayList<Token>();

        StringBuffer tokenPatternsBuffer = new StringBuffer();
        for (TokenType tokenType : TokenType.values())
            tokenPatternsBuffer.append(String.format("|(?<%s>%s)", tokenType.name(), tokenType.pattern));
        Pattern tokenPatterns = Pattern.compile(new String(tokenPatternsBuffer.substring(1)));

        Matcher matcher = tokenPatterns.matcher(input);
        while (matcher.find()) {
            tokens=matchTokenTypes(tokens, matcher);
        }

        return tokens;
    }


    private List<Token> matchTokenTypes(List<Token> tokens, Matcher matcher) {

        for(TokenType tokenType:TokenType.tokenTypes){			
            if (matcher.group(TokenType.WHITESPACE.name()) != null){
                //do nothing
            }			

            else if(matcher.group(tokenType.name())!=null){
                //			    System.out.println(matcher.group());
                if(tokenType.toString().equals("INBRACKETS")){
                    makeTokensFromBrackets(tokens, matcher, tokenType);
                    isFalse=true;
                }			
                else{
                    tokens.add(new Token(tokenType, matcher.group(tokenType.name())));	
                    isFalse=false;
                }
            }
        }	
        return tokens;
    }


    private void makeTokensFromBrackets(List<Token> tokens,Matcher matcher, TokenType tokenType) {
        String data = matcher.group(tokenType.name());
        if(isFalse)
            tokenType = TokenType.FALSE;
        data = data.substring(2,data.length()-2);
        for(String element:data.split(" "))
            tokens.add(new Token(tokenType, element));
    }

    public static void main(String[] args) {
        String input = "fd :get";
        // Create tokens and print them
        Lexer l = new Lexer();
        List<Token> tokens = l.lex(input);
        for (Token token : tokens)
            System.out.println(token.data + " : " + token.type);
    }
}