package parse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Set;

import model.Model;
import parse.Lexer.Token;

import commands.Command;
import commands.CommandList;
import commands.Constant;
import commands.CustomCommand;
import commands.Variable;

/*
 * Takes raw input in string form, parses the information, and returns a list of trees with all of the commands
 */
public class Parser {
	private String myInput;
	private boolean isNewCommand = false;
	private Set<Command> trueBracketCommands = new HashSet<Command>();
	private Set<Command> falseBracketCommands = new HashSet<Command>();
	private Map<String, Variable> variableMap = new HashMap<String, Variable>();
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	ResourceBundle myResources;

	public Parser(String input, String language) {
		myInput = input;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
				+ language);

	}

	/*
	 * Makes a list of tokens, uses these tokens to create a list of commands,
	 * and uses these commands to create a list of nodes
	 * 
	 * @return list of nodes, one for each command
	 */
	public List<Node> parseToNodeList() {
		List<Token> tokens = makeTokenList();
		List<Command> commandList = makeCommandList(tokens);
		List<Node> NodeList = new ArrayList<Node>();
		while (!commandList.isEmpty()) {
			NodeList.add(buildTree(commandList, new Node(commandList.get(0))));
		}
		return NodeList;
	}

	/*
	 * Creates a new lexer which breaks the raw input into tokens
	 * 
	 * @return List of tokens, one for each command
	 */
	private List<Token> makeTokenList() {
		Lexer lexer = new Lexer();
		return lexer.lex(myInput);
	}

	/*
	 * Loops through a list of tokens and creates a list of commands.
	 * 
	 * @param tokens list of tokens, one for each command
	 * 
	 * @return list of commands
	 */
	private List<Command> makeCommandList(List<Token> tokens) {
		List<Command> commandList = new ArrayList<Command>();
		for (Token token : tokens) {
			Command curCommand = getCommandType(token);
			commandList.add(curCommand);
			if (token.type.toString().equals("INBRACKETS"))
				trueBracketCommands.add(curCommand);
			if (token.type.toString().equals("FALSE"))
				falseBracketCommands.add(curCommand);
		}
		return commandList;
	}

	/*
	 * Recursively builds a tree from the list of commands
	 * 
	 * @param commandList List of commands
	 * 
	 * @param n Current node. Used for recursive purposes
	 * 
	 * @return Node that acts as the root of the tree
	 */
	private Node buildTree(List<Command> commandList, Node n) {
		Command root = commandList.get(0);
		commandList.remove(0);
		Node node = n;

		for (int i = 0; i < root.getNumInputs(); i++) {
			node.addToChildrenList(commandList.get(0));
			buildTree(commandList, node.getLastChild());
		}
		if (root instanceof CommandList) {
			addBracketCommands(commandList, root, node);
		}

		return node;
	}

	private void addBracketCommands(List<Command> commandList, Command root,
			Node node) {
		while (commandList.size() > 0
				&& trueBracketCommands.contains(commandList.get(0))) {
			node.addToChildrenList(commandList.get(0));
			((CommandList) root).incrementNumInputs();
			buildTree(commandList, node.getLastChild());
		}

		while (commandList.size() > 0
				&& falseBracketCommands.contains(commandList.get(0))) {
			node.addToFalseChildrenList(commandList.get(0));
			((CommandList) root).incrementNumFalseInputs();
			buildTree(commandList, node.getLastFalseChild());
		}

	}

	/*
	 * Uses reflection to get the class name from the string value of each
	 * token. Creates a command from each class.
	 * 
	 * @param token
	 * 
	 * @return Command that token represents
	 */
	private Command getCommandType(Token token) {
		List<String> s = findPackageNamesStartingWith("");
		if (isNumeric(token.data))
			return new Constant(Double.parseDouble(token.data));
		if (token.data.startsWith(":")) {
			return makeVariable(token.data);

		}
		// All commands must be in the commands package
		try {
			if (Model.customCommandList.keySet().contains(token.data)) {
				return Model.customCommandList.get(token.data);
			}
			token.data = myResources.getString(token.data.toLowerCase());
			if (token.data.equals("To"))
				isNewCommand = true;
			return (Command) Class.forName("commands." + token.data)
					.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

		} catch (MissingResourceException e) {
			if (isNewCommand) {
				isNewCommand = false;
				return new CustomCommand(token.data);
			}
			e.printStackTrace();

		}

		return null;
	}

	/*
	 * Adds a variable to a map that maps variable names to variables
	 * 
	 * @param variableName String name of the variable
	 * 
	 * @return Command representation of the variable
	 */
	private Command makeVariable(String variableName) {
		if (!variableMap.keySet().contains(variableName)) {
			Variable var = new Variable(0);
			variableMap.put(variableName, var);
			return var;
		}
		return variableMap.get(variableName);
	}

	public List<String> findPackageNamesStartingWith(String prefix) {
		List<String> result = new ArrayList<>();
		for (Package p : Package.getPackages()) {
			if (p.getName().startsWith(prefix)) {
				result.add(p.getName());
			}
		}
		return result;
	}

	/*
	 * Helper method that determines if a String can be parsed to a Double
	 * 
	 * @param str String to be tested
	 * 
	 * @return Boolean that states if the input can be parsed to a Double
	 */
	private boolean isNumeric(String str) {
		try {
			Double.parseDouble(str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
}
