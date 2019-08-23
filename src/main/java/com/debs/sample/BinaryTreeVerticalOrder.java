package com.debs.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class BinaryTreeVerticalOrder {
	
	public static void solution(BinaryTreeNode node, int height, Map<Integer, List<Integer>> map){
		
		if(map== null)
			return;
		List<Integer> list = map.get(height);
		
		if(list == null){
			list = new ArrayList<Integer>();
			list.add(node.data);
		}
		else{
			list.add(node.data);
		}
		map.put(height, list);
		solution(node.leftNode, height -1, map);
		solution(node.rightNode, height +1, map);
		
	}
	
	static void printVerticalOrder(BinaryTreeNode root)
    {
        // Create a map and store vertical oder in map using
        // function getVerticalOrder()
        Map<Integer,List<Integer>> m = new HashMap<Integer,List<Integer>>();
        int hd =0;
        solution(root,hd,m);
         
        // Traverse the map and print nodes at every horigontal
        // distance (hd)
        for (Entry<Integer, List<Integer>> entry : m.entrySet())
        {
            System.out.println(entry.getValue());
        }
    }
     
    // Driver program to test above functions
    public static void main(String[] args) {
 
    	/*BinaryTreeNode root = new BinaryTreeNode(1);
        root.leftNode = new BinaryTreeNode(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        root.right.left.right = new Node(8);
        root.right.right.right = new Node(9);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);*/
    }

}
