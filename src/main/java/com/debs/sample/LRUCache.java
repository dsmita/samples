package com.debs.sample;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	
	int capacity;
	Map<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	DoubleLinkedListNode head = null;
	DoubleLinkedListNode end = null ;
	
	public LRUCache(int capacity){
		this.capacity = capacity;
	}
	
	public int get(int key){
		if(map.containsKey(key)){
			DoubleLinkedListNode node = map.get(key);
			remove(node);
			setHead(node);
			return node.value;
		} 
		return -1;
	}
	
	public void set(int key, int value){
		if(map.containsKey(key)){
			DoubleLinkedListNode old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
			
		} else {
			DoubleLinkedListNode created = new DoubleLinkedListNode(key, value);
			if(map.size()>=capacity){
				map.remove(end.key);
				remove(end);
				setHead(created);
			
			}else{
				setHead(created);	
			}
			map.put(key, created);
		}
	}

	public void remove(DoubleLinkedListNode node) {
		if(node.prev != null){
			node.prev.next = node.next;
		} else{
			head = node.next;
		}
		
		if(node.next != null){
			node.next.prev = node.prev;
		}else{
			end = node.prev;
		}
		
	}
	
	public void setHead(DoubleLinkedListNode node){
		node.prev = null;
		node.next = head;
		
		if(head != null)
			head.prev = node;
		
		head = node;
	}

}
