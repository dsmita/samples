package com.debs.sample;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilterNames {
	/*
	 * "manish", "charles", "cameron", "vicky", "chaplin");
Filter and Make new Array with All names starting with "C"
Capitalize the first Letter of the Names starting with "C"
Use Streams and ForEach
	 */

	public List<String> solution(List<String> myList){
		List<String> filteredNames = new ArrayList<String>();
		if(myList == null)
			return null;
		for(String name:myList){
			if(name.charAt(0)== 'c' ||name.charAt(0)== 'C'){
				StringBuilder sb = new StringBuilder();
				sb.append("C").append(name.substring(1, name.length()-1));
				sb.toString();
				filteredNames.add(sb.toString());
			}
		}
		return filteredNames;
	}
	
	public List<String> solutionUsingStreams(List<String> myList){
		if(myList == null)
			return null;
		Stream<String> streamCollection = myList.stream();
		List<String> filteredNames = new ArrayList<String>();
		streamCollection.filter(s->s.charAt(0)=='C').forEach(filteredNames.add(s));
		
		return filteredNames;
	}
}
