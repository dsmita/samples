package com.debs.sample;

import java.util.Arrays;

public class CountOccurrencesOfAnagram {

	public int solution(String word, String text){
		int length = word.length();
		int count=0;
		for(int i=0;i<=text.length()-length;i++){
			if(checkAnagram(word, text.substring(i, i+length), length))
				count++;
		}
		return count;
	}

	private boolean checkAnagram(String word, String b, int length) {
		char[] wordArr = word.toCharArray();
		Arrays.sort(wordArr);
		char[] bArr= b.toCharArray();
		Arrays.sort(bArr);
		for(int i=0;i<length;i++){
			if(wordArr[i] != bArr[i]){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		CountOccurrencesOfAnagram coa = new CountOccurrencesOfAnagram();
		int count = coa.solution("aaba", "aabaabaa");
		System.out.println(count);
	}
}
