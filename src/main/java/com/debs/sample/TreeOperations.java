package com.debs.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeOperations {

	private final static Integer MIN = Integer.MIN_VALUE;
	private final static Integer MAX = Integer.MAX_VALUE;

	public boolean isBST(BinaryTreeNode node) {
		if (node == null)
			return true;
		else{
			 boolean leftOk = isBST(node.leftNode, MIN, node.data);
			 if(!leftOk)
				 return false;
			 boolean rightok = isBST(node.rightNode, node.data+1, MAX);
			 return rightok;
		}
	}

	private boolean isBST(BinaryTreeNode node, Integer min, Integer max) {
		if (node.data >= min && node.data < max)
			return true;
		else
			return false;
	}

	public boolean isSame(BinaryTreeNode node1, BinaryTreeNode node2) {
		if (node1 == null && node2 == null)
			return true;
		else if (node1 == null && node2 != null)
			return false;
		else if (node1 != null && node2 == null)
			return false;
		else if (!node1.data.equals(node2.data))
			return false;
		return (node1.data.equals(node2.data) && isSame(node1.leftNode, node2.leftNode) && isSame(node1.rightNode, node2.rightNode));
	}

	public Integer maxDepth(BinaryTreeNode node) {
		if (node == null)
			return 0;
		return 1 + Math.max(maxDepth(node.leftNode), maxDepth(node.rightNode));
	}

	public void printTree(BinaryTreeNode node) {
		if (node == null)
			return;
		printTree(node.leftNode);
		System.out.println(node.data);
		printTree(node.rightNode);
	}

	public void printPostOrder(BinaryTreeNode node) {
		if (node == null)
			return;

		printPostOrder(node.leftNode);
		printPostOrder(node.rightNode);
		System.out.println(node.data);
	}

	public boolean hasPathSum(BinaryTreeNode node, int sum) {
		if (node == null)
			return false;
		else if (node.data > sum)
			return false;
		else if (node.data == sum && node.leftNode == null && node.rightNode == null)
			return true;
		else {
			int subsum = sum - node.data;
			return (hasPathSum(node.leftNode, subsum) || hasPathSum(node.rightNode, subsum));
		}
	}
	
	public List<ArrayList<Integer>> getPathSum(BinaryTreeNode node, int sum){
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> individualList = new ArrayList<Integer>();
		return getPathSumDFS(node, sum , list, individualList);
	}

	
	private ArrayList<ArrayList<Integer>> getPathSumDFS(BinaryTreeNode node, int sum, ArrayList<ArrayList<Integer>> finalList, ArrayList<Integer> individualList) {
		if(node == null)
			return finalList;
		else if(node.data == sum && node.leftNode == null && node.rightNode == null){
			individualList.add(node.data);
			ArrayList<Integer> temp = new ArrayList<Integer>(individualList);
			finalList.add(temp);
		} else if(node.leftNode != null){
			int subsum = sum - node.data;
			individualList.add(node.leftNode.data);
			getPathSumDFS(node.leftNode, subsum, finalList, individualList);
			int length=individualList.size();
			individualList.remove(length -1);
		} else if(node.rightNode != null){
			int subsum = sum - node.data;
			individualList.add(node.rightNode.data);
			getPathSumDFS(node.rightNode, subsum, finalList, individualList);
			int length=individualList.size();
			individualList.remove(length -1);
		}
		
		
		return finalList;
	}

	public void printPaths(BinaryTreeNode node) {
		int[] paths = new int[1000];
		int pathlength = 0;
		printPaths(node, paths, pathlength);
	}

	private void printPaths(BinaryTreeNode node, int[] paths, int pathlength) {
		if (node == null)
			return;
		paths[pathlength] = node.data;
		pathlength++;

		if (node.leftNode == null && node.rightNode == null) {
			printArray(paths);
		} else {
			printPaths(node.leftNode, paths, pathlength);
			printPaths(node.rightNode, paths, pathlength);
		}

	}

	private void printArray(int[] paths) {
		for (int i = 0; i < paths.length; i++) {
			System.out.print(paths[i] + " ");
		}
	}
	
	public void convertBinaryTreeToMirrorTree(BinaryTreeNode node){
		if(node!=null){
			convertBinaryTreeToMirrorTree(node.leftNode);
			convertBinaryTreeToMirrorTree(node.rightNode);
			
			//swap
			BinaryTreeNode temp = node.leftNode;
			node.leftNode = node.rightNode;
			node.rightNode = temp;
		}
	}
	
	public boolean isMirror(BinaryTreeNode node){
		if(node == null)
			return true;
		return isMirror(node.leftNode, node.rightNode);
	}
	
	private boolean isMirror(BinaryTreeNode left, BinaryTreeNode right){
		if(left == null && right == null)
			return true;
		if(left!=null && right!= null && left.data==right.data)
			return (isMirror(left.leftNode,right.rightNode) && isMirror(left.rightNode, right.leftNode));
		return false;
	}
	
	public void bottomView(BinaryTreeNode node){
		if(node == null)
			return;
		List<Integer> nodeList = new ArrayList<Integer>();
		bottomViewUtil(node, nodeList);
		for(Integer data:nodeList){
			System.out.println(data + " ");
		}
	}
	
	private List<Integer> bottomViewUtil(BinaryTreeNode node, List<Integer> nodeList){
		if(node == null)
			return null;
		if(node.leftNode == null && node.rightNode == null)
			nodeList.add(node.data);
		bottomViewUtil(node.leftNode, nodeList);
		bottomViewUtil(node.rightNode, nodeList);
		
		return nodeList;
	}
	
	public BinaryTreeNode LCA(BinaryTreeNode root, BinaryTreeNode node1, BinaryTreeNode node2){
		if(node1 == null && node2==null)
			return null;
		else if(node1.data == root.data || node1.data == root.data)
			return root;
		else if(node1.data < root.data && node2.data > root.data)
			return root;
		else if(node1.data < root.data && node2.data < root.data)
			return LCA(root.leftNode, node1, node2);
		else if(node1.data > root.data && node2.data > root.data)
			return LCA(root.rightNode, node1, node2);
		return null;
	}
	
	public List<ArrayList<Integer>> verticalView(BinaryTreeNode node){
		if(node == null)
			return null;
		int level=0;
		HashMap<Integer, List<Integer>> map= verticalViewUtil(node, level);
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(List<Integer> valueList: map.values()){
			list.add((ArrayList<Integer>) valueList);
		}
		return list;
	}
	
	private HashMap<Integer, List<Integer>> verticalViewUtil(BinaryTreeNode node, int level) {
		HashMap<Integer, List<Integer>> map= new HashMap<Integer, List<Integer>>();
		if(map.get(level)!=null){
			List<Integer> existingList = map.get(level);
			existingList.add(node.data);
			map.put(level, existingList);
		} else {
			List<Integer> newList = map.get(level);
			newList.add(node.data);
			map.put(level, newList);
		}
		verticalViewUtil(node.leftNode, level-1);
		verticalViewUtil(node.rightNode, level+1);
		return map;
	}
	
	//https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
	public BinaryTreeNodeWithNext populateNextPointersInEachNode(BinaryTreeNodeWithNext node) {
		if (node == null)
			return null;
		LinkedList<BinaryTreeNodeWithNext> queue = new LinkedList<BinaryTreeNodeWithNext>();
		queue.add(node);
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				BinaryTreeNodeWithNext curr = queue.poll();
				BinaryTreeNodeWithNext next = (i == size - 1) ? null : queue.peek();
				curr.next = next;

				if (curr.leftNode != null)
					queue.offer(curr.leftNode);
				if (curr.rightNode != null)
					queue.offer(curr.rightNode);
			}
		}
		return node;
	}
	
	//https://www.geeksforgeeks.org/flatten-a-binary-tree-into-linked-list/
	public void convertBinaryTreeToLinkedList(BinaryTreeNode head){
		if(head == null)
			return;
		Stack<BinaryTreeNode> stack = new Stack<BinaryTreeNode>();
		BinaryTreeNode node = head;
		while(node != null || !stack.isEmpty()){
		if(node.rightNode != null){
			stack.push(node.rightNode);
		}
		
		if(node.leftNode!=null){
			node.rightNode=node.leftNode;
			node.leftNode=null;
		}else if(!stack.empty()){
            BinaryTreeNode temp = stack.pop();
            node.rightNode=temp;
        }

        node = node.rightNode;
		}	
	}

	public int getClosestValue(BinaryTreeNode root, double target){
		double min = Double.MAX_VALUE;
		int goal =0;
		getClosestValue(root, target, min, goal);
		return goal;
	}
	
	private void getClosestValue(BinaryTreeNode root, double target, double min, int goal) {
		if(root == null)
			return;
		if(Math.abs(root.data-target)<min){
			min=Math.abs(root.data-target);
			goal=root.data;
		}
		if(root.data>target)
			getClosestValue(root.leftNode, target,min,goal);
		else
			getClosestValue(root.rightNode, target,min,goal);
	}

	public static void main(String args[]) 
    { 
		BinaryTreeNode tree4 = new BinaryTreeNode(4, null, null); 
		BinaryTreeNode tree5 = new BinaryTreeNode(5, null, null); 
		BinaryTreeNode tree3 = new BinaryTreeNode(3, null, null);
		BinaryTreeNode tree2 = new BinaryTreeNode(2, tree4, tree5); 
		BinaryTreeNode tree1 = new BinaryTreeNode(1, tree2, tree3); 
         
		TreeOperations lot = new TreeOperations();
       lot.bottomView(tree1); 
    } 

}
