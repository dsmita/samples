package com.debs.sample;

public class NodeWithRandomPointer {

	public int val;
	public NodeWithRandomPointer next;
	public NodeWithRandomPointer random;

	public NodeWithRandomPointer() {
	}
	
	public NodeWithRandomPointer(int val) {
		this.val=val;
	}


	public NodeWithRandomPointer(int val, NodeWithRandomPointer next, NodeWithRandomPointer random) {
		this.val = val;
		this.next = next;
		this.random = random;
	}

}
