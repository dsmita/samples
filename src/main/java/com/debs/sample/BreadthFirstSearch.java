package com.debs.sample;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BreadthFirstSearch {

	public boolean solution(TreeNode node, TreeNode search) {
		Set<Integer> visitedSet = new HashSet<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		if (node == null)
			return false;

		/*if (node.data == search.data) {
			visitedSet.add(node.data);
			return true;
		} else {*/
			queue.add(node);
			while (!queue.isEmpty()) {
				TreeNode nodeToBeRemoved = (TreeNode) queue.poll();
				if (nodeToBeRemoved != null) {
					visitedSet.add(nodeToBeRemoved.data);
					if (nodeToBeRemoved.data == search.data)
						return true;
					List<TreeNode> nodeList = nodeToBeRemoved.nodes;
					if (nodeList != null) {
						for (TreeNode nodeL : nodeList) {
							if (!visitedSet.contains(nodeL.data)) {
								queue.add(nodeL);
								visitedSet.add(nodeL.data);
							}
						}
					}
				}
			}
//		}
		return false;
	}

	public static void main(String args[]) {
		BreadthFirstSearch bfs = new BreadthFirstSearch();

		TreeNode node1 = new TreeNode();
		node1.data = 1;

		TreeNode node2 = new TreeNode();
		node2.data = 2;

		TreeNode node3 = new TreeNode();
		node3.data = 3;

		List<TreeNode> nodeList1 = new ArrayList<TreeNode>();
		nodeList1.add(node2);
		nodeList1.add(node3);

		node1.nodes = nodeList1;

		TreeNode node4 = new TreeNode();
		node4.data = 4;

		TreeNode node5 = new TreeNode();
		node5.data = 5;

		List<TreeNode> nodeList2 = new ArrayList<TreeNode>();
		nodeList2.add(node4);
		nodeList2.add(node5);

		node2.nodes = nodeList2;

		List<TreeNode> nodeList3 = new ArrayList<TreeNode>();
		nodeList3.add(node5);

		node3.nodes = nodeList3;

		TreeNode node6 = new TreeNode();
		node6.data = 6;

		List<TreeNode> nodeList4 = new ArrayList<TreeNode>();
		nodeList4.add(node6);
		nodeList4.add(node5);

		node4.nodes = nodeList4;

		TreeNode searchNode = new TreeNode();
		searchNode.data = 1;

		boolean val = bfs.solution(node1, searchNode);
		System.out.println(val);
	}

}
