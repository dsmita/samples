package com.debs.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class CourseSchedule2 {

	public int[] findOrder(int numCourses, int[][] prerequisites){
		if(prerequisites == null){
	        throw new IllegalArgumentException("illegal prerequisites array");
	    }
	 
	    int length = prerequisites.length;
	    int[] order = new int[numCourses];
	    
	    if(length==0){
	    	for(int i=0;i<numCourses;i++){
	    		order[i]=i;
	    	}
	    	return order;
	    }
	    
	    HashMap<Integer, ArrayList<Integer>> courseMap = new HashMap<Integer, ArrayList<Integer>>();
		for (int[] a : prerequisites) {
			if (courseMap.containsKey(a[1])) {
				ArrayList<Integer> arr = courseMap.get(a[1]);
				arr.add(a[0]);
				courseMap.put(a[1], arr);
			} else {
				ArrayList<Integer> arr = new ArrayList<Integer>();
				arr.add(a[0]);
				courseMap.put(a[1], arr);
			}
		}
		
		//stores courses that have no prerequisites
		LinkedList<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i<numCourses;i++){
			if(!courseMap.containsKey(i))
				queue.add(i);
		}
	}
}
