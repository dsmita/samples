package com.debs.sample;

public class DoublyLinkedListOperations {
	
	public DoubleLinkedListNode reverse(DoubleLinkedListNode head){
		if(head == null || head.next== null)
			return head;
		DoubleLinkedListNode newHead = null;
		DoubleLinkedListNode curr = head;
		while(curr != null){
			newHead = addToHead(curr, newHead);
			curr = curr.next;
		}
		head = newHead;
		return head;
	}

	private DoubleLinkedListNode addToHead(DoubleLinkedListNode node, DoubleLinkedListNode head) {
		node.prev = null;
		node.next = head;
		
		if(head != null)
			head.prev = node;
		
		head = node;
		return head;
	}

}
