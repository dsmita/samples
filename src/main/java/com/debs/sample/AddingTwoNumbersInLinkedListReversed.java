package com.debs.sample;

public class AddingTwoNumbersInLinkedListReversed {

	public static LinkedListNode solution(LinkedListNode n1, LinkedListNode n2){
		LinkedListNode result = new LinkedListNode(0,null);
		LinkedListNode curr = result;
		LinkedListNode temp = null;
		
		int digitSum =0, carryover =0;
		while(n1 != null && n2!= null){
			digitSum =  n1.data + n2.data + carryover;
			if(digitSum > 9){
				carryover =1;
				digitSum = digitSum -10;
			}
			temp = new LinkedListNode(digitSum, null);
			curr.next=temp;
			curr = curr.next;
			n1=n1.next;
			n2=n2.next;
		}
		while(n1 != null){
			digitSum = n1.data+carryover;
			if(digitSum > 9){
				carryover =1;
				digitSum = digitSum -10;
			}
			temp = new LinkedListNode(digitSum, null);
			curr.next=temp;
			curr = curr.next;
			n1=n1.next;
		}
		while(n2!=null){
			digitSum = n2.data+carryover;
			if(digitSum > 9){
				carryover =1;
				digitSum = digitSum -10;
			}
			temp = new LinkedListNode(digitSum, null);
			curr.next=temp;
			curr = curr.next;
			n2=n2.next;
		}
		return result.next;
	}
	
	public static void main(String[] args) {
		LinkedListNode n3 = new LinkedListNode(5, null);
		LinkedListNode n2 = new LinkedListNode(3, n3);
		LinkedListNode n1= new LinkedListNode(2, n2);
		
		LinkedListNode n6 = new LinkedListNode(2, null);
		LinkedListNode n5 = new LinkedListNode(3, n6);
		LinkedListNode n4 = new LinkedListNode(1, n5);
		
		LinkedListNode result = solution(n1, n4);
		while(result != null){
			System.out.println(result.data);
			result = result.next;
		}
	}
}
