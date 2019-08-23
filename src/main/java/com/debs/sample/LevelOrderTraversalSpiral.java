package com.debs.sample;

import java.util.Stack;

public class LevelOrderTraversalSpiral {
	
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
		}else if(n>1 && n%2==0){
			printGivenLevel(n-1, node.leftNode);
			printGivenLevel(n-1, node.rightNode);
		}else if(n>1 && n%2!=0){
			printGivenLevel(n-1, node.rightNode);
			printGivenLevel(n-1, node.leftNode);
		}
	}
	
	public void printLevelOrder(BinaryTreeNode node) 
    { 
        int h = maxDepth(node); 
        int i; 
        for (i=1; i<=h; i++) 
            printGivenLevel(i,node); 
    }
	
	public void printLevelOrderSpiralByStack(BinaryTreeNode node) {
		
		if(node == null)
			return;

		Stack<BinaryTreeNode> st1 = new Stack<BinaryTreeNode>();
		Stack<BinaryTreeNode> st2 = new Stack<BinaryTreeNode>();

		st1.push(node);

		while (!st1.isEmpty() || !st2.isEmpty()) {
			while (!st1.isEmpty()) {
				BinaryTreeNode temp = st1.peek();
				st1.pop();
				System.out.print(temp.data + " ");

				if (temp.rightNode != null)
					st2.push(temp.rightNode);
				if (temp.leftNode != null)
					st2.push(temp.leftNode);
			}

			while (!st2.isEmpty()) {
				BinaryTreeNode temp2 = st2.peek();
				st2.pop();
				System.out.println(temp2.data + " ");

				if (temp2.leftNode != null)
					st1.push(temp2.leftNode);
				if (temp2.rightNode != null)
					st1.push(temp2.rightNode);
			}
		}

	}
	
	public static void main(String args[]) 
    { 
		BinaryTreeNode tree4 = new BinaryTreeNode(4, null, null); 
		BinaryTreeNode tree5 = new BinaryTreeNode(5, null, null);
		BinaryTreeNode tree6 = new BinaryTreeNode(6, null, null);
		BinaryTreeNode tree7 = new BinaryTreeNode(7, null, null);
		BinaryTreeNode tree3 = new BinaryTreeNode(3, null, null);
		BinaryTreeNode tree2 = new BinaryTreeNode(2, tree4, tree5); 
		BinaryTreeNode tree1 = new BinaryTreeNode(1, tree2, tree3); 
         
		LevelOrderTraversalSpiral lot = new LevelOrderTraversalSpiral();
       System.out.println("Level order traversal of binary tree is "); 
       lot.printLevelOrderSpiralByStack(tree1); 
    } 

}
