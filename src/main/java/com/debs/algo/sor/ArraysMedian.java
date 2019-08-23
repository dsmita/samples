package com.debs.algo.sor;


public class ArraysMedian {

	public int getMedianOfTwoArrays(int[] a1, int[] a2, int start1, int end1, int start2, int end2) {
		int length = end1 - start1 + 1;
		if (length == 0)
			return -1;
		if (length == 1)
			return (a1[0] + a2[0]) / 2;
		if (length == 2)
			return (Math.max(a1[start1 + 0], a2[start2 + 0]) + Math.min(a1[start1 + 1], a2[start2 + 1])) / 2;
		int m1 = getMedian(a1, start1, end1);
		int m2 = getMedian(a2, start2, end2);

		if (m1 == m2)
			return m1;
		else if (m1 > m2) {
			if (length % 2 == 0) {
				return getMedianOfTwoArrays(a1, a2, start1 + 0, start1 + (length / 2), start2 + (length / 2) - 1, start2 + length - 1);
			} else {
				return getMedianOfTwoArrays(a1, a2, start1 + 0, start1 + ((length - 1) / 2), start2 + ((length - 1) / 2), start2 + length - 1);
			}
		} else {
			if (length % 2 == 0) {
				return getMedianOfTwoArrays(a1, a2, start1 + (length / 2) - 1, start1 + length - 1, start2 + 0, start2 + (length / 2));
			} else {
				return getMedianOfTwoArrays(a1, a2, start1 + ((length - 1) / 2), start1 + length - 1, start2 + 0, start2 + ((length - 1) / 2));
			}
		}
	}

	private int getMedian(int[] a1, int start, int end) {
		int length = end - start + 1;
		if (length % 2 == 0)
			return (a1[start + (length / 2)] + a1[start + (length / 2) - 1]) / 2;
		else
			return a1[start + ((length - 1) / 2)];

	}

	public static void main(String[] args) {
		int ar1[] = { 2, 3, 5, 10, 17, 19 };
		int ar2[] = { 1, 8, 9, 11, 15, 20 };
		ArraysMedian arraysMedian = new ArraysMedian();
		System.out.println("Median is " + arraysMedian.getMedianOfTwoArrays(ar1, ar2, 0, 5, 0, 5));

		System.out.println("Median is "
				+ arraysMedian.getMedianOfTwoArrays(new int[] { 5, 104, 109, 301, 400 }, new int[] { 97, 99, 205, 350, 375 }, 0, 4, 0, 4));
	}
}
