package com.debs.sample;

import java.util.LinkedList;

public class SerializeDeserializeBinaryTree {

	public String serialize(BinaryTreeNode node) {
		StringBuilder sb = new StringBuilder();
		if (node == null) {
			sb.append("#");
			return sb.toString();
		}
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		queue.add(node);
		while (!queue.isEmpty()) {
			BinaryTreeNode bn = queue.poll();
			if (bn != null) {
				sb.append(bn.data + ",");
				queue.add(bn.leftNode);
				queue.add(bn.rightNode);
			} else {
				sb.append("#,");
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	
	public BinaryTreeNode deserialize(String s){
		String[] arr = s.split(",");
		BinaryTreeNode root = new BinaryTreeNode(Integer.parseInt(arr[0]), null, null);
		LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
		
		queue.add(root);
		int i=1;
		while(!queue.isEmpty()){
			BinaryTreeNode node = queue.poll();
			if(node==null)
				continue;
			if(arr[i].equals("#")){
				node.leftNode = null;
				queue.offer(null);
			} else{
				node.leftNode = new BinaryTreeNode(Integer.parseInt(arr[i]), null, null);
				queue.offer(node.leftNode);
			}
			i++;
			if(arr[i].equals("#")){
				node.rightNode = null;
				queue.offer(null);
			} else{
				node.rightNode = new BinaryTreeNode(Integer.parseInt(arr[i]), null, null);
				queue.offer(node.rightNode);
			}
			i++;
		}
		return root;
	}
}
