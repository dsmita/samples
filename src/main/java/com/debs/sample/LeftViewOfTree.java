package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class LeftViewOfTree {
	
	int maxLevel =0;
	public void solution(BinaryTreeNode node, int level){
		if(node == null)
			return;
		if(maxLevel<level){
			System.out.print(" " + node.data); 
            maxLevel = level;
		}
		solution(node.leftNode, level+1);
		solution(node.rightNode, level+1);
	}
	
	public List<Integer> rightSideView(BinaryTreeNode root) {
        if(root == null)
            return null;
        List<Integer> result = new ArrayList<Integer>();
        
        rightSideViewUtil(root, 1, result);
        return result;
    }
    
    public void rightSideViewUtil(BinaryTreeNode root, int level, List<Integer> list){
        if(root == null)
            return;
        if(level > maxLevel){
            list.add(root.data);
            maxLevel = level;
        }
        rightSideViewUtil(root.rightNode,level+1, list);
        rightSideViewUtil(root.leftNode,level+1, list);
    }
	
	public static void main(String args[]) 
    { 
		BinaryTreeNode tree4 = new BinaryTreeNode(4, null, null); 
		BinaryTreeNode tree5 = new BinaryTreeNode(5, null, null); 
		BinaryTreeNode tree3 = new BinaryTreeNode(3, null, null);
		BinaryTreeNode tree2 = new BinaryTreeNode(2, tree4, tree5); 
		BinaryTreeNode tree1 = new BinaryTreeNode(1, tree2, tree3); 
         
		LeftViewOfTree lot = new LeftViewOfTree();
       System.out.println("Level order traversal of binary tree is "); 
       lot.solution(tree1, 1); 
    } 

}
