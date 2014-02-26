package parse;

import java.util.ArrayList;
import java.util.List;

import commands.Command;

public class Node {
	private Node myRoot;
	private Command myData;
	private Node myParent;

	private List<Node> myChildrenList = new ArrayList<Node>();
	private List<Node> myFalseChildrenList = new ArrayList<Node>();
	
	public Node(Command command){
		myData=command;
	}

	public void addToChildrenList(Command command){
		Node node = new Node(command);
		node.myParent=this;
		this.myChildrenList.add(node);
	}
	public void addToFalseChildrenList(Command command){
		Node node = new Node(command);
		node.myParent=this;
		this.myFalseChildrenList.add(node);
	}

	public List<Node> getChildrenList(){
		return this.myChildrenList;
	}
	public List<Node> getFalseChildrenList(){
		return this.myFalseChildrenList;
	}
	
	public Node getParent(){
		return this.myParent;
	}
	public Command getCommand(){
		return this.myData;
	}
	public Node getLastChild(){
		return this.myChildrenList.get(this.myChildrenList.size()-1);
	}
	public Node getLastFalseChild(){
		return this.myFalseChildrenList.get(this.myFalseChildrenList.size()-1);
	}
}

