package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePermutations {
	
	public static List<ArrayList<Integer>> getAllPermutations(List<Integer> a){
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		int length = a.size();
		if(length == 0 || length ==1)
			result.add((ArrayList<Integer>) a);
		else{
			Integer last=a.get(length -1);
			List<Integer> rest=new ArrayList<Integer>();
			for(int i=0;i < length-1;i++){
				rest.add(a.get(i));
			}
			result = merge(getAllPermutations(rest), last);
		}
		return result;
	}
	
	public static List<ArrayList<Integer>> merge(List<ArrayList<Integer>> a, Integer b){
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		for(ArrayList<Integer> arr: a){
			for(int i=0; i<arr.size()+1;i++){
				arr.add(i,b);
				
				ArrayList<Integer> temp = new ArrayList<Integer>(arr);
				result.add(temp);
				
				arr.remove(i);
				
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		List<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		List<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		result = getAllPermutations(a);
		for(ArrayList<Integer> arr: result){
			for(int i=0; i<arr.size();i++){
				System.out.println(arr.get(i) + "  ");
			}
		}
	}

}
