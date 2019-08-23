package com.debs.sample;

public class RegularExpressionMatch {
	
	public boolean solution(String p, String s){
		if(p.length() == 0)
			return s.length()==0;
		else if(p.length() == 1){
			return (p.equals(s) || s.equals("*") || s.equals("."));
		} else{
			if(s.charAt(0) == '*'){
				//case 2.1: a char & '*' can stand for 0 element
				if (solution(p, s.substring(2))) {
					return true;
				}
		 
				//case 2.2: a char & '*' can stand for 1 or more preceding element, 
				//so try every sub string
				int i = 0;
				while (i<p.length() && (p.charAt(i)==s.charAt(0) || s.charAt(0)=='.')){
					if (solution(p.substring(i + 1), s.substring(2))) {
						return true;
					}
					i++;
				}
				return false;
			} else{
				if (s.length() < 1) {
					return false;
				}
				if ((p.charAt(0) != s.charAt(0)) && (s.charAt(0) != '.')) {
					return false;
				} else {
					return solution(s.substring(1), p.substring(1));
				}
			}
		}
	}

}
