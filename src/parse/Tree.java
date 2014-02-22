package parse;

import java.util.ArrayList;
import java.util.List;

import parse.Lexer.Token;

public class Tree<T> {
    private Node<T> root;

    
    public Tree(List<Token> tokens) {
        root = new Node<T>();
        //not sure what to make root data yet
        root.data = null;
        root.children = new Node[2];
        
    }

    public class Node<T> {
        private Token data;
        private Node<T> parent;
        private Node<T>[] children;
        
        public void setLeftChild(Token token){
        	Node<T> node = new Node<T>();
        	node.data=token;
        	node.parent=this;
        	this.children[0]=node;
        }
        public void setRightChild(Token token){
        	Node<T> node = new Node<T>();
        	node.data=token;
        	node.parent=this;
        	this.children[1]=node;
        }
        public Node<T> getLeftChild(){
        	return this.children[0];
        }
        public Node<T> getRightChild(){
        	return this.children[1];
        }
        public Node<T> getParent(){
        	return this.parent;
        }
        public Token getToken(){
        	return this.data;
        }
        
    }
    
    
    
}

