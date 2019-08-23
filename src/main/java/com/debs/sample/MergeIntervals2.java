package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals2 {
	
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size()==0)
		    return null;
		List<Interval> result = new ArrayList<Interval>();
		Interval lastInterval = intervals.get(0);
		for(int i=1;i<intervals.size();i++){
			Interval currentInterval = intervals.get(i);
			if(lastInterval.getStartTime() <currentInterval.getStartTime() &&
					lastInterval.getEndTime() > currentInterval.getStartTime()){
				Integer endTime = Math.max(lastInterval.getEndTime(), currentInterval.getEndTime());
				lastInterval.setEndTime(endTime);
			}else{
				result.add(lastInterval);
				lastInterval = currentInterval;
			}
		}
		return result;
    } 

}
