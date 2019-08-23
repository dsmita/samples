package com.debs.algo.sor;

public class MaxHeap {

	private int[] data;

	public int[] getData() {
		return data;
	}

	public MaxHeap(int[] data) {
		this.data = data;
		maxHeapify(data, data.length);
	}

	private void maxHeapify(int a[], int length) {
		int lastIndex = length - 1;
		int parentIndex = (length / 2) - 1;

		while (parentIndex >= 0) {

			int leftChildIndex = parentIndex * 2 + 1;
			int rightChildIndex = leftChildIndex + 1;

			int swapIndex = parentIndex;
			if (leftChildIndex <= lastIndex) {
				swapIndex = a[leftChildIndex] > a[swapIndex] ? leftChildIndex : swapIndex;
			}
			if (rightChildIndex <= lastIndex) {
				swapIndex = a[rightChildIndex] > a[swapIndex] ? rightChildIndex : swapIndex;
			}

			if (swapIndex != parentIndex) {
				swap(a, parentIndex, swapIndex);
			}
			parentIndex--;
		}
	}

	private void swap(int[] a, int index1, int index2) {
		int temp = a[index2];
		a[index2] = a[index1];
		a[index1] = temp;
	}

	private void sort() {

	}

	public static void main(String[] args) {

		int[] inputData = new int[] { 4, 1, 3, 2, 16, 9, 10, 14, 8, 7 };
		print(inputData);

		MaxHeap maxHeap = new MaxHeap(inputData);
		print(maxHeap.getData());

		maxHeap.sort();
	}

	private static void print(int[] data) {
		StringBuilder builder = new StringBuilder();
		for (int i : data) {
			builder.append(i + ",");
		}
		builder.deleteCharAt(builder.lastIndexOf(","));
		System.out.println(builder.toString());
	}

}
