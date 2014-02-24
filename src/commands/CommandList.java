package commands;

import java.util.List;

import parse.Node;

public abstract class CommandList extends Command{
	public CommandList() {
		super.myNumInputs=2;
	}
	private Node myCommandList;
	
	public void setCommandList(Node node){
		myCommandList = node;
	}
	
	
	public Command[] getInputs(){
		setInnerCommands();
		return new Command[] {myInput1,myInput2};
	}
	public Node getCommandList(){
		return myCommandList;
	}
	
	public void setInnerCommands(){
		Node commandNode = myCommandList;
		Command curCommand = commandNode.getCommand();
		if(commandNode.getLeftChild()!=null)
			curCommand.setInput1((Command)commandNode.getLeftChild().getCommand());
		if(commandNode.getRightChild()!=null)
			curCommand.setInput2((Command)commandNode.getRightChild().getCommand());
		setInput2(curCommand);
		
	}
	

	
	
	

	

}
