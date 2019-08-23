package com.debs.sample;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz {
	
	public List<String> solution(int n) {
		List<String> list = new ArrayList<String>();
        for(int i = 1; i<=n;i++){
        	StringBuilder sb = new StringBuilder();
        	if(i%3 == 0){
        		sb.append("Fizz");
        	}
        	if(i%5 == 0){
        		sb.append("Buzz");
        	}
        	if(i%3 !=0 && i%5 != 0){
        		sb.append(i);
        	}
        	list.add(sb.toString());
        }
        return list;
    }
	
	public static void main(String[] args) {
		FizzBuzz fb = new FizzBuzz();
		List<String> list = fb.solution(3);
		for(String s:list){
			System.out.println(s);
		}
	}

}
