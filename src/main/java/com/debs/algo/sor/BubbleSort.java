package com.debs.algo.sor;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

	public List<Integer> sort(List<Integer> a) {
		for (int j = a.size(); j >= 0; j--) {
			for (int i = 0; i + 1 < j; i++) {
				if (a.get(i) > a.get(i + 1)) {
					Integer temp = a.get(i + 1);
					a.set(i + 1, a.get(i));
					a.set(i, temp);
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		BubbleSort bubbleSort = new BubbleSort();

		List<Integer> a = new ArrayList<Integer>();
		a.add(2);
		a.add(4);
		a.add(5);
		a.add(3);
		a.add(1);
		List<Integer> b = bubbleSort.sort(a);
		System.out.println(b);
	}
}
