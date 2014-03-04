package commands.basic;

import java.util.ArrayList;
import java.util.List;

import model.TurtleState;
import parse.Node;

/*
 * Abstract super class that defines a general Command
 */
public abstract class Command {
	private int myNumInputs;
	private List<Command> myInputs = new ArrayList<Command>();

	public int getNumInputs() {
		return myNumInputs;
	}

	public void setNumInputs(int numInputs) {
		myNumInputs = numInputs;
	}

	public void addInput(Command command) {
		myInputs.add(command);
	}

	public List<Command> getInputs() {
		return myInputs;
	}

	public void clearInputs() {
		myInputs = new ArrayList<Command>();
	}

	public void setInputsFromNode(Node node) {
		for (int i = 0; i < myNumInputs; i++) {
			for (Node child : node.getChildrenList()) {
				addInput(child.getCommand());
				child.getCommand().setInputsFromNode(child);
			}
		}
	}

	public abstract Object doCommand(TurtleState turtleState);
}
