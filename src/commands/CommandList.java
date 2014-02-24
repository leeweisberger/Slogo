package commands;

import java.util.List;

import parse.Node;

public abstract class CommandList extends Command{
	public CommandList() {
		super.myNumInputs=2;
	}
	private List<Node> myCommandList;

	public void setCommandList(List<Node> list){
		myCommandList = list;
	}


	public Command[] getInputs(){
		setInnerCommands();
		return new Command[] {myInput1,myInput2};
	}
	public List<Node> getCommandList(){
		return myCommandList;
	}

	public void setInnerCommands(){
		for(Node commandNode: myCommandList){
			Command curCommand = commandNode.getCommand();
			if(commandNode.getLeftChild()!=null)
				curCommand.setInput1((Command)commandNode.getLeftChild().getCommand());
			if(commandNode.getRightChild()!=null)
				curCommand.setInput2((Command)commandNode.getRightChild().getCommand());
			setInput2(curCommand);
		}
	}








}
