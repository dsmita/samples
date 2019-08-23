package com.debs.sample;

import java.util.ArrayList;
import java.util.HashMap;

public class PhonePadCombinations {
	public static ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<String> preres = new ArrayList<String>();
		res.add("");

		for (int i = 0; i < digits.length(); i++) {
			String letters = map.get(digits.charAt(i));
			if (letters.length() == 0)
				continue;
			for (String str : res) {
				for (int j = 0; j < letters.length(); j++)
					preres.add(str + letters.charAt(j));
			}
			/*res.clear();
		    res.addAll(preres);*/
			res=preres;
			preres = new ArrayList<String>();
		}
		return res;
	}

	static final HashMap<Character, String> map = new HashMap<Character, String>() {
		{
			put('1', "");
			put('2', "abc");
			put('3', "def");
			put('4', "ghi");
			put('5', "jkl");
			put('6', "mno");
			put('7', "pqrs");
			put('8', "tuv");
			put('9', "wxyz");
			put('0', "");
		}
	};
	
	public static void main(String[] args) {
		ArrayList<String> result= letterCombinations("234");
		System.out.println(result.size());
		System.out.println(result);
	}
}
