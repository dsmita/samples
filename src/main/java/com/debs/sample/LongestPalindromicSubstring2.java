package com.debs.sample;

public class LongestPalindromicSubstring2 {
	
	static int longestPalSubstr(String str) { 
        int maxLength = 1, start=0, low=0, high=0, len= str.length();  
  
        for (int i = 1; i < len; ++i)  
        { 
            // Find the longest even length palindrome with  
            // center points as i-1 and i. 
            low = i - 1; 
            high = i; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
  
            // Find the longest odd length palindrome with  
            // center point as i 
            low = i - 1; 
            high = i + 1; 
            while (low >= 0 && high < len 
                    && str.charAt(low) == str.charAt(high)) { 
                if (high - low + 1 > maxLength) { 
                    start = low; 
                    maxLength = high - low + 1; 
                } 
                --low; 
                ++high; 
            } 
        } 
  
        System.out.print("Longest palindrome substring is: "); 
  
        return maxLength; 
    } 
	
	
}
