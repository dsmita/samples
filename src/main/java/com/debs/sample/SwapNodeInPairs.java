package com.debs.sample;

public class SwapNodeInPairs {

	public LinkedListNode swapPairs(LinkedListNode head) {
		if (head == null || head.next == null)
			return null;

		LinkedListNode fakeHead = new LinkedListNode(0, head);
		LinkedListNode pre = fakeHead;

		LinkedListNode p1 = head;
		LinkedListNode p2 = head.next;

		while (p1 != null && p2 != null) {
			LinkedListNode temp = p2.next;
			p2.next = p1;
			p1.next = temp;

			pre = p1;
			p1 = p1.next;

			if (temp != null) {
				p2 = temp.next;
			}
		}
		return fakeHead.next;
	}

}
