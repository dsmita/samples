package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

	// search - binary search, add - O(n)
	public List<Interval> solution(List<Interval> intervals, Interval newInterval) {
		List<Interval> result = new ArrayList<Interval>();

		if (intervals.size() == 0)
			result.add(newInterval);

		int p = searchInterval(intervals, newInterval);
		result.addAll(intervals.subList(0, p));

		for (int i = p; i < intervals.size(); i++) {
			Interval interval = intervals.get(p);
			if (interval.getEndTime() < newInterval.getStartTime()) {
				result.add(interval);
				interval = newInterval;
			} else if (newInterval.getEndTime() < interval.getStartTime()) {
				result.add(newInterval);
			} else if (newInterval.getStartTime() < interval.getEndTime()
					|| interval.getStartTime() < newInterval.getEndTime()) {
				newInterval = new Interval(Math.min(interval.getStartTime(), newInterval.getStartTime()),
						Math.max(interval.getEndTime(), newInterval.getEndTime()));
			}
		}
		result.add(newInterval);
		return result;
	}

	private int searchInterval(List<Interval> intervals, Interval newInterval) {
		int low = 0;
		int high = intervals.size() - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (newInterval.getStartTime() <= intervals.get(mid).getStartTime()) {
				high = mid;
			} else
				low = mid + 1;
		}

		return high;
	}

}
