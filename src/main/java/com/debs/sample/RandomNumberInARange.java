package com.debs.sample;

import java.util.Random;

public class RandomNumberInARange {
	
	private static boolean[] visited = new boolean[5-0+1];
	
	public static int generateRandomInRange(Integer min, Integer max, int count){
		
		int random =(int)(Math.random()*(max-min+1));
		if(visited[random]){
			generateRandomInRange(min, max, count);
		}else{
			visited[random]=true;
			count++;
			return random;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int count=0;
		Random random = new Random();
		while(count <6 && !visited[count]){
			visited[count] = true;
		    System.out.println(random.nextInt(5));
		    count++;
		}
	}

}
