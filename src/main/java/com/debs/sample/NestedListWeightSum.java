package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class NestedListWeightSum {
	
	public static int solution(List<NestedInteger> nestedList){
		return solution(nestedList,1);
	}

	private static int solution(List<NestedInteger> nestedList, int level) {
		int result =0;
		if(nestedList == null || nestedList.isEmpty())
			return 0;
		for(NestedInteger n:nestedList){
			if(n.isInteger()){
				result = result + n.getInteger()*level;
			} else{
				result = result + solution(n.getList(), level+1);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		NestedListWeightSum ns = new NestedListWeightSum();
		System.out.println(solution(null));
		List<NestedInteger> nestedList = new ArrayList<NestedInteger> ();
		nestedList.add(2);
		ns.solution({{1,1},2,{1,1}});
	}

}
