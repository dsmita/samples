package com.debs.sample;

import java.util.ArrayList;
import java.util.Arrays;

public class Subsets {
	
	public ArrayList<ArrayList<Integer>> solution(int[] s){
		if(s==null)
			return null;
		Arrays.sort(s);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<s.length;i++){
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
			
			//get sets that are already in result
			for(ArrayList<Integer> a:result){
				temp.add(new ArrayList<Integer>(a));
			}
			
			//add s[i] to existing sets
			for(ArrayList<Integer> a:temp){
				a.add(s[i]);
			}
			
			//add s[i] as a single set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(s[i]);
			result.add(single);
			result.addAll(temp);
		}
		
		//add empty set
		result.add(new ArrayList<Integer>());
	 
		return result;
	}
	
	public static void main(String[] args) {
		Subsets subsets = new Subsets();
		int[] s ={1,2};
		ArrayList<ArrayList<Integer>> result= subsets.solution(s);
		for(ArrayList<Integer> temp: result){
			System.out.println(temp);
		}
	}

}
