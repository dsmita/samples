package com.debs.sample;

public class ClosestValueInBST {

	int min = Integer.MAX_VALUE;
	int result = 0;

	public int solution(BinaryTreeNode root, int target) {
		if (root == null)
			return -1;
		int diff = Math.abs(root.data - target);
		if (diff < min) {
			min = Math.min(min, diff);
			result = root.data;
		}
		if (target < root.data) {
			solution(root.leftNode, target);
		} else
			solution(root.rightNode, target);
		return result;
	}

}
