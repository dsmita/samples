package com.debs.sample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class LongestValidParentheses {
	
	public int solution(String s){
		Stack<String> parenthesesStack = new Stack<String>();
		int count =0;
		int maxCount =0;
		for(int i=0;i<s.length();i++){
			if(!parenthesesStack.isEmpty() && s.charAt(i)== ')'){
				count ++;
				parenthesesStack.pop();
			} else if(s.charAt(i)== '('){
				count++;
				parenthesesStack.push("(");
			}
			if(parenthesesStack.isEmpty() && maxCount < count)
				maxCount = count;
		}
		return maxCount;
	}
	
	public boolean isValid(String s){
		Map<Character, Character> bracesMap = new HashMap<Character, Character>();
		Stack<Character> stack = new Stack<Character>();
		bracesMap.put(')', '(');
		bracesMap.put('}', '{');
		bracesMap.put(']', '[');
		
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(bracesMap.containsValue(c)){
				stack.push(c);
			} else {
				if(stack.isEmpty())
					return false;
				else{
					if(stack.pop() != bracesMap.get(c))
						return false;
				}
			}
		}
		return stack.isEmpty()? true:false;
	}
	
	public List<String> generateParenthesis(int n){
		List<String> result = new ArrayList<String>();
		return generateParenthesis("",result, n, n);
	}
	
	private List<String> generateParenthesis(String s, List<String> result, int left, int right) {
		if(left>right)
			return result;
		if(left==0 && right==0){
			result.add(s);
			return result;
		}
		if(left>0)
			generateParenthesis(s+"(", result, left-1, right);
		if(right>0)
			generateParenthesis(s+")", result, left, right-1);
		return result;
	}

	public static void main(String[] args) {
		LongestValidParentheses lv = new LongestValidParentheses();
		/*int i = lv.solution(")(()())");
		System.out.println(i);*/
		List<String> list = lv.generateParenthesis(3);
		for(String str:list){
			System.out.println(str);
		}
	}

}
