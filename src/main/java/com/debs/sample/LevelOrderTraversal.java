package com.debs.sample;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	public int maxDepth(BinaryTreeNode node){
		if(node == null)
			return 0;
		else return 1+ Math.max(maxDepth(node.leftNode), maxDepth(node.rightNode));
	}
	
	public void printGivenLevel(int n, BinaryTreeNode node){
		if(node == null)
			return;
		if(n == 1){
			System.out.println(node.data+" ");
		}else if(n>1){
			printGivenLevel(n-1, node.leftNode);
			printGivenLevel(n-1, node.rightNode);
		}
	}
	
	public void printLevelOrder(BinaryTreeNode node) 
    { 
        int h = maxDepth(node); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(i,node); 
    }
	
	public void printLevelOrderUsingQueue(BinaryTreeNode node){
		if(node == null)
			return ;
		Queue<BinaryTreeNode> list = new LinkedList<BinaryTreeNode>();
		list.add(node);
		while(!list.isEmpty()){
			BinaryTreeNode temp = list.poll();
			System.out.println(temp.data + " ");
			if(temp.leftNode != null)
				list.add(temp.leftNode);
			if(temp.rightNode != null)
				list.add(temp.rightNode);
		}
	}
	
	public static void main(String args[]) 
    { 
		BinaryTreeNode tree4 = new BinaryTreeNode(4, null, null); 
		BinaryTreeNode tree5 = new BinaryTreeNode(5, null, null); 
		BinaryTreeNode tree3 = new BinaryTreeNode(3, null, null);
		BinaryTreeNode tree2 = new BinaryTreeNode(2, tree4, tree5); 
		BinaryTreeNode tree1 = new BinaryTreeNode(1, tree2, tree3); 
         
		LevelOrderTraversal lot = new LevelOrderTraversal();
       System.out.println("Level order traversal of binary tree is "); 
       lot.printLevelOrderUsingQueue(tree1); 
    } 

}
