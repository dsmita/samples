package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class WeightedCharacters {
	
	List<Character> chars = new ArrayList<Character>();
	List<Long> weight = new ArrayList<Long>();
	
	public String solution(long k){
		populateWeightAndChar();
		StringBuilder sb = new StringBuilder();
		int stopIndex = findStopIndex(k);
		findCombination(k, stopIndex, sb);
		return sb.toString();
	}
	
	private void findCombination(long target, int stopIndex, StringBuilder sb){
		if(weight.contains(target)){
			sb.append(chars.get(stopIndex));
			return ;
		} else if(target <=0){
			return;
		} else{
			sb.append(chars.get(stopIndex));
			target = target - weight.get(stopIndex);
			stopIndex = findStopIndex(target);
			findCombination(target, stopIndex, sb);
		}
	}
	
	private int findStopIndex(long k){
		int stopIndex = 0;
		for(int i=0;i<=26;i++){
			if(weight.get(i) > k){
				stopIndex = i-1;
				break;
			} 
		}
		return stopIndex;
	}
	
	public void populateWeightAndChar(){
		int i=1;
		weight.add(1L);
		chars.add(new Character('A'));
		for(char c='B'; c<='Z';c++){
			weight.add((i+1)*weight.get(i-1) +(i+1));
			chars.add(c);
			i++;
		}
		System.out.println(chars);
		System.out.println(weight);
	}
	
	public static void main(String[] args) {
		WeightedCharacters wc = new WeightedCharacters();
		String s = wc.solution(1970);
		System.out.println(s);
	}

}
