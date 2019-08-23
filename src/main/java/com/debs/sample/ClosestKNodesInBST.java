package com.debs.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ClosestKNodesInBST {

	private BinaryTreeNode root;
	
	public List<BinaryTreeNode> printKNeighbours(int value, int k) {
        List<BinaryTreeNode> path = pathToRoot(value);
        if (path.size() == 0){
            return Collections.EMPTY_LIST;
        }
        for (int i = 0; i < path.size(); i++) {
        	BinaryTreeNode current = path.get(i);
            current.level = i;
        }
        return fetchkNeighbours(k);
    }
	
	private List<BinaryTreeNode> fetchkNeighbours(int k) {

        List<BinaryTreeNode> kList = new ArrayList<BinaryTreeNode>();
        LinkedList<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();

        queue.add(root);
        if (root.level == k) {
            kList.add(root);
        }

        while (!queue.isEmpty()) {

        	BinaryTreeNode node = queue.poll();

            if (node.leftNode != null) {
                node.leftNode.level = node.level + 1;
                queue.addFirst(node.leftNode);
                if (node.leftNode.level == k){
                    kList.add(node.leftNode);
                }
            }

            if (node.rightNode != null) {
                node.rightNode.level = node.level + 1;
                queue.addFirst(node.rightNode);
                if (node.rightNode.level == k){
                    kList.add(node.rightNode);
                }
            }
        }

        return kList;
    }
	
	private List<BinaryTreeNode> pathToRoot(int value) {

        List<BinaryTreeNode> normal = findPath(value);
        Collections.reverse(normal);

        return normal;
    }
    /*
        Returns a path to the node containing value. Otherwise returns empty list
     */
    private List<BinaryTreeNode> findPath(int value) {

        if (root == null) {
            return Collections.EMPTY_LIST;
        }

        List<BinaryTreeNode> path = new ArrayList<BinaryTreeNode>();
        BinaryTreeNode current = root;

        while (current != null) {

            path.add(current);
            if (current.data == value) {
                break;
            }
            if (value < current.data) {
                current = current.leftNode;
            }else {
               current = current.rightNode;
            }
        }

        return current != null ? path : Collections.EMPTY_LIST;
    }
	
}
