package com.debs.sample;

public class MedianOfTwoSortedArrays {

	public int solution(int[] a, int[] b, int mlow , int mhigh, int nlow, int nhigh) {
		int m1 = findMedian(a, mlow, mhigh);
		int m2 = findMedian(b, nlow, nhigh);
		
		if(m1 == m2)
			return m1;
		else if(m1 > m2){
			mhigh = m1;
			nlow = m2;
			return solution(a, b, mlow, mhigh, nlow, nhigh );
		} else {
			mlow =m1;
			nhigh = m2;
			return solution(a, b, mlow, mhigh, nlow, nhigh );
		}
	}

	private int findMedian(int[] a, int i, int length) {
		if (length == 0)
			return 0;
		else if (length == 1)
			return a[0];
		else if (length % 2 != 0)
			return a[(length - 1) / 2];
		else if (length % 2 == 0)
			return (a[length / 2] + a[length / 2 - 1]) / 2;
		return 0;
	}
}
