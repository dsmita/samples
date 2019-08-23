package com.debs.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class LinkedListOperations {

	LinkedListNode start;

	public boolean isCyclic(LinkedListNode start) {
		LinkedListNode currn1 = start;
		LinkedListNode currn2 = start;
		while (currn1 != null && currn2 != null && currn1.data == currn2.data) {
			currn1 = currn1.next;
			currn2 = currn2.next.next;
			return true;
		}
		return false;
	}

	public Integer count(LinkedListNode start) {
		LinkedListNode curr = start;
		Integer count = 0;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	public Integer getNth(LinkedListNode start, Integer m) {
		LinkedListNode curr = start;
		Integer count = 0;
		while (curr != null && count < m) {
			count++;
			curr = curr.next;
		}
		return curr.data;
	}
	
	public Integer getNthFromEnd(LinkedListNode start, Integer m) {
		LinkedListNode curr = start;
		LinkedListNode fast = start;
		Integer count = 1;
		while (fast != null && count < m) {
			count++;
			fast = fast.next;
		}
		while(fast.next!=null){
			fast = fast.next;
			curr = curr.next;
		}
		return curr.data;
	}
	
	
	public LinkedListNode removeNthFromEnd(LinkedListNode start, Integer m){
		LinkedListNode curr = start;
		LinkedListNode fast = start;
		LinkedListNode prev = null;
		Integer count =1;
		
		while(fast!=null && count < m){
			fast = fast.next;
			count++;
		}
		
		while(fast.next!=null){
			prev = curr;
			fast = fast.next;
			curr=curr.next;
		}
		prev.next = curr.next;
		return start;
	}
	
	public LinkedListNode mergeTwoSortedLists(LinkedListNode l1, LinkedListNode l2){
		LinkedListNode result = new LinkedListNode(0, null);
		LinkedListNode current = result;
		
		while (l1 != null && l2 != null) {
			if (l1.data <= l2.data) {
				LinkedListNode toBeAdded = new LinkedListNode(l1.data, null);
				current.next = toBeAdded;
				l1 = l1.next;
			} else {
				LinkedListNode toBeAdded = new LinkedListNode(l2.data, null);
				current.next = toBeAdded;
				l2 = l2.next;
			}
			current = current.next;
		}
		while(l1!=null){
			LinkedListNode toBeAdded = new LinkedListNode(l1.data, null);
			current.next = toBeAdded;
			l1 = l1.next;
			current=current.next;
		}
		while(l2!=null){
			LinkedListNode toBeAdded = new LinkedListNode(l2.data, null);
			current.next = toBeAdded;
			l2 = l2.next;
			current=current.next;
		}
		return result.next;
	}
	
	public Integer getMiddleElement(LinkedListNode start){
		if(start == null)
			return 0;
		if(start.next == null || start.next.next == null)
			return 0;
		
		LinkedListNode current = start;
		LinkedListNode doubleSpeed = start;
		while(current != null && doubleSpeed != null){
			current = current.next;
			doubleSpeed = current.next.next;
		}
		return current.data;
	}

	public Integer pop(LinkedListNode start) {
		Integer dataToBePopped = start.data;
		start = start.next;
		return dataToBePopped;
	}

	public Integer insertNth(LinkedListNode start, LinkedListNode toBeInserted, Integer n) {
		LinkedListNode curr = start;
		Integer count = 0;
		while (curr != null && count < n) {
			count++;
			curr = curr.next;
		}
		LinkedListNode next = curr.next;
		curr.next = toBeInserted;
		toBeInserted.next = next;
		return start.data;
	}

	public LinkedListNode sortedInsert(LinkedListNode start, LinkedListNode toBeInserted) {
		LinkedListNode curr = start;
		while (curr != null && toBeInserted.data > curr.data) {
			curr = curr.next;
		}
		LinkedListNode next = curr.next;
		curr.next = toBeInserted;
		toBeInserted.next = next;

		return start;
	}

	public LinkedListNode mergeSort(LinkedListNode left, LinkedListNode right) {
		LinkedListNode result = new LinkedListNode(0, null);
		LinkedListNode merged = result;
		while (left != null && right != null) {
			if (left.data <= right.data) {
				merged.next = left;
				left = left.next;
			} else {
				merged.next = right;
				right = right.next;
			}
			merged=merged.next;
		}
		if (left == null && right != null) {
			merged = right.next;
			right = right.next;
			merged=merged.next;
		}
		if (right == null && left != null) {
			merged = left.next;
			left = left.next;
			merged = merged.next;
		}
		return result.next;
	}
	
	public LinkedListNode mergeTwoListsInPlace(LinkedListNode a, LinkedListNode b){
		if(a == null && b == null)
			return null;
		if(a != null && b == null)
			return a;
		else if(a == null && b != null)
			return b;
		else {
			if(a.data <= b.data){
				 a.next= mergeTwoListsInPlace(a.next, b);
				 return a;
			} else {
				 b.next= mergeTwoListsInPlace(a, b.next);
				 return b;
			}
		}
		
	}
	
	public LinkedListNode mergeKLists(List<LinkedListNode> lists){
		if(lists == null)
			return null;
		 return mergeKLists(lists, 0, lists.size()-1);
	}
	
	private LinkedListNode mergeKLists(List<LinkedListNode> lists, int start, int end) {
		if(start<end){
			int mid = (start+end)/2;
			return mergeTwoListsInPlace(mergeKLists(lists, start, mid), mergeKLists(lists, mid+1, end));
		}
		return lists.get(start);
	}
	
	public LinkedListNode mergeKListsUsingPriorityQueue(List<LinkedListNode> lists){
		if(lists == null || lists.size()==0)
			return null;
		
		 /*PriorityQueue<LinkedListNode> pq = new PriorityQueue<LinkedListNode>(lists.size(), new Comparator<LinkedListNode>() {
	            @Override
	            public int compare(LinkedListNode o1, LinkedListNode o2) {
	                return o1.val - o2.val;
	            }
	        });*/
		PriorityQueue<LinkedListNode> pq = new PriorityQueue<LinkedListNode>(lists.size());
		for(LinkedListNode node:lists){
			pq.add(node);
		}
		
		LinkedListNode head = new LinkedListNode(0,null);
		LinkedListNode current = head;
		while(!pq.isEmpty()){
			LinkedListNode node= pq.poll();
			if(node.next != null)
				pq.add(node.next);
			node.next = null;
			current.next = node;
			current = current.next;
		}
		return head.next;
	}

	public LinkedListNode addNodeToHead(LinkedListNode start, LinkedListNode toBeAdded){
		toBeAdded.next = start;
		return toBeAdded;
	}
	
	public LinkedListNode reverse(LinkedListNode start){
		LinkedListNode curr = start;
		LinkedListNode reverse = new LinkedListNode(curr.data, null);
		while(curr != null){
			curr = curr.next;
			curr = addNodeToHead(reverse, curr);
		}
		return reverse;
	}
	
	public LinkedListNode recursiveReverse(LinkedListNode start){
		LinkedListNode current = start;
		LinkedListNode prev = null;
		LinkedListNode next = null;
		while(current != null){
			next=current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	public boolean isPalindrome(LinkedListNode start){
		LinkedListNode current = start;
		Stack<LinkedListNode> s1 = new Stack<LinkedListNode>();
		while(current != null){
			s1.push(current);
			current = current.next;
		}
		
		current= start;
		while(!s1.isEmpty() && current != null){
			if(s1.pop().data != current.data)
				return false;
			current = current.next;
		}
		return true;
	}
	
	public void mergeKSortedLists(List<LinkedListNode> list){
		
	}
	
	public static void main(String[] args) {
		LinkedListNode next5 = new LinkedListNode(5, null);
		LinkedListNode next4 = new LinkedListNode(4, next5);
		LinkedListNode next2 = new LinkedListNode(3, next4);
		LinkedListNode next1 = new LinkedListNode(2, next2);
		LinkedListNode start = new LinkedListNode(1, next1);
		LinkedListOperations li = new LinkedListOperations();
		/*LinkedListNode reverse = li.reverse(start);
		LinkedListNode current = reverse;
		
		while(current != null){
			System.out.println(current.data + "###");
			current = current.next;
		}*/
		
		/*boolean bol = li.isPalindrome(start);*/
//		LinkedListNode l1 = li.removeNthFromEnd(start, 2);
		
		String s = "Debasmita";
		List<String> list= new ArrayList<String>();
		list.add(s);
		s=null;
		System.out.println(s);
		System.out.println(list.get(0));
	}
}
