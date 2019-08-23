package com.debs.sample;

public class ReverseNodesInGroup {
	
	//1->2->3->4->5->6->7->8 -----> 3->2->1->6->5->4->8->7
	public LinkedListNode reverse(LinkedListNode head, int k){
		
		LinkedListNode next = null;
		LinkedListNode prev = null;
		LinkedListNode curr = head;
		
		int count=0;
		while(curr != null && count < k){
			next = curr.next;
			curr.next = prev;
			prev=curr;
			curr=next;
			count++;
		}
		
		if(next!=null)
			head.next=reverse(next,k);
		
		return prev;
	}
	
	//1->2->3->4->5->6->7->8 -----> 3->2->1->6->5->4->7->8
	public LinkedListNode reverse2(LinkedListNode head, int k){
		
		LinkedListNode next = null;
		LinkedListNode prev = null;
		LinkedListNode curr = head;
		
		int count=0;
		while(curr != null && count < k){
			next = curr.next;
			curr.next = prev;
			prev=curr;
			curr=next;
			count++;
		}
		int count1=0;
		LinkedListNode curr1=curr;
		while(curr!=null && count1<k){
			curr1=curr1.next;
		}
		if(count1 != k-1)
			return prev;
		
		
		if(next!=null)
			head.next=reverse(next,k);
		
		return prev;
	}

}
