package parse;

import parse.Lexer.Token;

import commands.Command;

public class Node {
	private Node myRoot;
	private Command myData;
	private Node myParent;
	private Node[] myChildren = new Node[2];
	
	public Node(Command command){
		myData=command;
	}
	public void setLeftChild(Command command){
		Node node = new Node(command);
		node.myParent=this;
		this.myChildren[0]=node;
	}
	public void setRightChild(Command command){
		Node node = new Node(command);
		node.myParent=this;
		this.myChildren[1]=node;
	}
	public Node getLeftChild(){
		return this.myChildren[0];
	}
	public Node getRightChild(){
		return this.myChildren[1];
	}
	public Node getParent(){
		return this.myParent;
	}
	public Command getCommand(){
		return this.myData;
	}





}

