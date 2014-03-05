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
import commands.CustomCommand;
import commands.basic.Command;
import commands.basic.CommandList;
import commands.basic.Constant;
import commands.basic.Variable;
import commands.movement.Forward;


/**
 * The Class Parser.
 */
public class Parser {
	
	/** The package list. */
	private String[] packageList = { "commands", "commands.math",
			"commands.direction", "commands.basic", "commands.movement",
			"commands.bool", "commands.control", "commands.queries",
			"commands.multiple" };

	/** The raw input. */
	private String myInput;
	
	/** check if a custom command should be created */
	private boolean isNewCommand = false;
	
	/** the set of commands in brackets */
	private Set<Command> trueBracketCommands = new HashSet<Command>();
	
	/** The set of commands in the second set of brackets */
	private Set<Command> falseBracketCommands = new HashSet<Command>();
	
	/** The variable map. Maps names to variable commands */
	private Map<String, Variable> variableMap = new HashMap<String, Variable>();
	
	/** The Constant DEFAULT_RESOURCE_PACKAGE. */
	private static final String DEFAULT_RESOURCE_PACKAGE = "resources.";
	
	
	ResourceBundle myResources;

	/**
	 * Instantiates a new parser.
	 *
	 * @param input the raw user input
	 * @param language the language
	 */
	public Parser(String input, String language) {
		myInput = input;
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCE_PACKAGE
				+ language);

	}

	/**
	 * Calls commands that parse the raw input to node list.
	 *
	 * @return the list of nodes
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

	/**
	 * Make token list from raw user input.
	 *
	 * @return the list of tokens
	 */
	private List<Token> makeTokenList() {
		Lexer lexer = new Lexer();
		return lexer.lex(myInput);
	}

	/**
	 * Make command list.
	 *
	 * @param tokens the list of tokens
	 * @return the list of commands
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

	/**
	 * Builds the tree recursively.
	 *
	 * @param commandList the list of commands
	 * @param n the current node
	 * @return the node that represents a tree
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

	/**
	 * Adds the bracket commands.
	 *
	 * @param commandList the command list
	 * @param root the root
	 * @param node the node
	 */
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

	/**
	 * Gets the command type.
	 *
	 * @param token the token
	 * @return the command type
	 */
	private Command getCommandType(Token token) {
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
			for (String packag : packageList) {
				String possibleLocation = packag + "." + token.data;
				try {
					return (Command) Class.forName(possibleLocation)
							.newInstance();
				} catch (ClassNotFoundException e) {

				}
			}
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
				//isNewCommand = false;
				
				return new CustomCommand(token.data);
			}
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * Make variable.
	 *
	 * @param variableName the variable name
	 * @return the command that represents the variable
	 */
	private Command makeVariable(String variableName) {
		if (!variableMap.keySet().contains(variableName)) {
			Variable var = new Variable(0);
			variableMap.put(variableName, var);
			return var;
		}
		return variableMap.get(variableName);
	}

	/**
	 * Checks if is numeric.
	 *
	 * @param str the string
	 * @return true, if is numeric
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
