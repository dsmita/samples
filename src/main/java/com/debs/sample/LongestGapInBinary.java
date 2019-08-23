package com.debs.sample;

public class LongestGapInBinary {
public int solution(int N) {
        
        int[] binary = convertToBinary(N);
        int gap= findLongestGapInBinary(binary);
        System.out.println("gap ### : " + gap);
        return gap;
        // write your code in Java SE 8
    }
    
    public int[] convertToBinary(int N){
        int count = 0;
        int [] binary = new int [40];
        while(N >0){
            binary[count] = N%2;
            N= N/2;
            System.out.println(binary[count]);
            count++;
        }
        return binary;
    }
    
    public int findLongestGapInBinary(int[] binary){
        int maxGap = 0;
        int count =0;
        boolean between = false;
        for(int i=0; i<binary.length -2; i++){
            if(binary[i] ==0 && between){
                count ++;
            }
            if(binary[i] == 1){
            	between = true;
                if(count > maxGap)
                    maxGap = count;
                count =0;
            }
        }
        return maxGap;
    }

    
    public static void main(String[] args) {
		LongestGapInBinary lb = new LongestGapInBinary();
		lb.solution(20);
		
	}
}
