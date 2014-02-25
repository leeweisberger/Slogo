package commands;

import java.util.ArrayList;
import java.util.List;

import parse.Node;

public abstract class CommandList extends Command{
	public CommandList() {
		super.setNumInputs(0);
	}
	private List<Node> myNodeList;
	private List<Command> myCommandList = new ArrayList<Command>();

	public void setCommandList(List<Node> list){
		myNodeList = list;
	}
	
	public void incrementNumInputs(){
		super.setNumInputs(super.getNumInputs()+1);
	}
	

//
//	public Command getConstantInput(){
//		return myInput1;
//	}
	
//	public List<Command> getCommandList(){
//		setInnerCommands();
//		return myCommandList;
//	}

//	public void setInnerCommands(){
//		for(Node commandNode: myNodeList){	
//			Command curCommand = commandNode.getCommand();
//			if(commandNode.getLeftChild()!=null)
//				curCommand.setInput1((Command)commandNode.getLeftChild().getCommand());
//			if(commandNode.getRightChild()!=null)
//				curCommand.setInput2((Command)commandNode.getRightChild().getCommand());
//			myCommandList.add(curCommand);
//		}
//	}








}
