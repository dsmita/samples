package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
	//assuming sorted list
	public List<ArrayList<Integer>> mergeIntervals(List<ArrayList<Integer>> intervals){
		List<ArrayList<Integer>> mergedIntervals = new ArrayList<ArrayList<Integer>>();
		for(int i=1;i<intervals.size();i++){
			if(intervals.get(i).get(0) < intervals.get(i-1).get(1)){
				ArrayList<Integer> localInterval = new ArrayList<Integer>();
				localInterval.add(Math.min(intervals.get(i).get(0), intervals.get(i-1).get(0)));
				localInterval.add(Math.max(intervals.get(i).get(1), intervals.get(i-1).get(1)));
				mergedIntervals.add(localInterval);
			}
		}
		return mergedIntervals;
	}
	
	public List<ArrayList<Integer>> addInterval(List<ArrayList<Integer>> intervals, List<Integer> toBeAdded){
		List<ArrayList<Integer>> mergedIntervals = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<intervals.size();i++){
			if(toBeAdded.get(0)> intervals.get(i).get(1) || toBeAdded.get(1)<intervals.get(i).get(0)){
				continue;
			} else {
				ArrayList<Integer> localInterval = new ArrayList<Integer>();
				localInterval.add(Math.min(toBeAdded.get(0), intervals.get(i).get(0)));
				localInterval.add(Math.max(toBeAdded.get(1), intervals.get(i).get(1)));
				mergedIntervals.add(localInterval);
			}
		}
		return mergedIntervals;
	}

}
