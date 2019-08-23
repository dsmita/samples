package com.debs.sample;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	Map<NodeWithRandomPointer, NodeWithRandomPointer> visited = new HashMap<NodeWithRandomPointer, NodeWithRandomPointer>();

	public NodeWithRandomPointer copyRandomList(NodeWithRandomPointer head) {

		if (head == null) {
			return null;
		}

		NodeWithRandomPointer curr = head;
		NodeWithRandomPointer newCurr = null;

		// Creating the copy.
		while(curr != null){
			newCurr = new NodeWithRandomPointer(curr.val);
			this.visited.put(curr, newCurr);
			curr = curr.next;
		}

		curr=head;
		// Iterate on the linked list until all nodes are cloned.
		while (curr != null) {
			// Get the clones of the nodes referenced by random and next
			// pointers.
			newCurr = visited.get(curr);
			newCurr.random = visited.get(curr.random);
			newCurr.next = visited.get(curr.next);

			curr = curr.next;
		}
		return this.visited.get(head);
	}

}
