package commands;

import java.util.ArrayList;
import java.util.List;

import parse.Node;

public abstract class CommandList extends Command{
	private List<Command> myFalseInputs = new ArrayList<Command>();
	private int myNumFalseInputs = 0;
	public CommandList() {
		//Assume there will be at least 1 command for the constant
		super.setNumInputs(1);
	}

	public void incrementNumInputs(){
		super.setNumInputs(super.getNumInputs()+1);
	}

	public void addFalseInput(Command command){
		myFalseInputs.add(command);
	}
	public List<Command> getFalseInputs(){
		return myFalseInputs;
	}

	public int getNumFalseInputs(){
		return myNumFalseInputs;
	}
	public void incrementNumFalseInputs(){
		myNumFalseInputs++;
	}
	@Override
	public void setInputsFromNode(Node node){
		for(int i=0; i<getNumInputs(); i++){
			for(Node child:node.getChildrenList()){
				addInput(child.getCommand());
				child.getCommand().setInputsFromNode(child);
			}
		}
		for(int i=0; i< myNumFalseInputs; i++){
			for(Node child:node.getFalseChildrenList()){
				addFalseInput(child.getCommand());
				child.getCommand().setInputsFromNode(child);
			}
		}
	}

}
