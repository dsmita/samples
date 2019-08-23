package com.debs.sample;

import java.util.ArrayList;

public class InsertInterval2 {
	
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval){
		ArrayList<Interval> result = new ArrayList<Interval>();
		if(intervals == null || intervals.size() == 0){
			result.add(newInterval);
			return result;
		}
		for(Interval interval:intervals){
			if(interval.getEndTime()<newInterval.getStartTime()){
				result.add(interval);
			} else if (interval.getStartTime() > newInterval.getEndTime()){
				result.add(newInterval);
				newInterval = interval;
			} else if(interval.getEndTime() >= newInterval.getStartTime() || newInterval.getEndTime()>= interval.getStartTime()){
				int startTime = Math.min(interval.getStartTime(), newInterval.getStartTime());
				int endTime = Math.max(interval.getEndTime(), newInterval.getEndTime());
				newInterval = new Interval(startTime, endTime);
			}
		}
		result.add(newInterval);
		return result;
	}

}
