package com.debs.sample;

import java.util.Stack;

public class BSTIterator {
	
	Stack<BinaryTreeNode> stack= new Stack<BinaryTreeNode>();
	
	BSTIterator(BinaryTreeNode node){
		while(node!=null){
			stack.push(node);
			node = node.leftNode;
		}
	}

	public boolean hasNext(){
		if(stack.isEmpty())
			return false;
		return true;
	}
	
	public BinaryTreeNode next(){
		if(!stack.isEmpty()){
			BinaryTreeNode node = stack.pop();
			addToStack(node.rightNode);
			return node;
		} else
			return null;
	}

	private void addToStack(BinaryTreeNode node) {
		while(!stack.isEmpty()){
			stack.push(node);
		}
		
	}
}
