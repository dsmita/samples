package com.debs.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}
		int len = prerequisites.length;

		if (numCourses == 0 || len == 0) {
			return true;
		}

		// track visited courses
		int[] visit = new int[numCourses];

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

		boolean[] visitedBoolean = new boolean[numCourses];
		HashSet<Integer> set = new HashSet<Integer>();
		int[] visited = new int[numCourses];

		for (int i = 0; i < numCourses; i++) {
			/*
			 * if(!canFinishDFSAlternate(courseMap, visitedBoolean, set, i))
			 * return false;
			 */
			if (!canFinishDFS(courseMap, visited, i))
				return false;
		}
		return true;
	}

	private boolean canFinishDFSAlternate(HashMap<Integer, ArrayList<Integer>> courseMap, boolean[] visited,
			HashSet<Integer> set, int i) {
		visited[i] = true;
		set.add(i);
		for (int j : courseMap.get(i)) {
			if (!visited[j]) {
				if(!canFinishDFSAlternate(courseMap, visited, set, j))
					return false;
			} else if (set.contains(j))
				return false;
		}
		set.remove(i);
		return true;
	}

	private boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> courseMap, int[] visited, int i) {
		if(visited[i] == -1)
			return false;
		if(visited[i] == 1)
			return true;
		visited[i] =-1;
		for(int j: courseMap.get(i)){
			if(visited[i] == 0){
				if(!canFinishDFS(courseMap,visited,j)){
					return false;
				}
			}
		}
		visited[i]=1;
		return true;
	}

}
