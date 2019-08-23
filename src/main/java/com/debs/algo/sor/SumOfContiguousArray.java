package com.debs.algo.sor;

import java.util.ArrayList;
import java.util.List;

public class SumOfContiguousArray {

	public Integer subArraySum(List<Integer> a) {
		Integer maxEndingHere = 0;
		Integer maxSoFar = 0;
		for (int i = 0; i < a.size(); i++) {
			maxEndingHere = maxEndingHere + a.get(i);

			if (maxEndingHere < 0)
				maxEndingHere = 0;

			if (maxEndingHere > maxSoFar)
				maxSoFar = maxEndingHere;
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		a.add(-2);
		a.add(-3);
		a.add(4);
		a.add(-1);
		a.add(-2);
		a.add(1);
		a.add(5);
		a.add(-3);
		SumOfContiguousArray sum = new SumOfContiguousArray();
		Integer b = sum.subArraySum(a);
		System.out.println(b);
	}

}
