package commands.basic;

import java.util.ArrayList;
import java.util.List;

import model.TurtleState;
import parse.Node;


/**
 * The Abstract Class Command.
 */
public abstract class Command {
	
	private int myNumInputs;
	
	private List<Command> myInputs = new ArrayList<Command>();

	/**
	 * Gets the num inputs.
	 *
	 * @return the num inputs
	 */
	public int getNumInputs() {
		return myNumInputs;
	}

	/**
	 * Sets the num inputs.
	 *
	 * @param numInputs the new num inputs
	 */
	public void setNumInputs(int numInputs) {
		myNumInputs = numInputs;
	}

	/**
	 * Adds the input to the list of inputs.
	 *
	 * @param command the command
	 */
	public void addInput(Command command) {
		myInputs.add(command);
	}

	/**
	 * Gets the inputs.
	 *
	 * @return the inputs
	 */
	public List<Command> getInputs() {
		return myInputs;
	}
	public void setInputs(ArrayList<Command> ins){
		myInputs = ins;
	}

	/**
	 * Clear inputs.
	 */
	public void clearInputs() {
		myInputs = new ArrayList<Command>();
	}

	/**
	 * Sets the command's inputs from a node.
	 *
	 * @param node the node that represents a command
	 */
	public void setInputsFromNode(Node node) {
		for (int i = 0; i < myNumInputs; i++) {
			for (Node child : node.getChildrenList()) {
				addInput(child.getCommand());
				child.getCommand().setInputsFromNode(child);
			}
		}
	}
	

	/**
	 * Do command.
	 *
	 * @param turtleState the turtle state
	 * @return the object that results from the command
	 */
	public abstract double doCommand(TurtleState turtleState);
}
