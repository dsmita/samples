package com.debs.sample;

public class LuckyNumber {
	
	public long solution(long a, long b){
		long count=0;
		long i=a;
		while(i<=b){
			long sumOfDigits = getSumOfDigits(i);
			long sumOfSquares = getSumOfSquareOfDigits(i);
			if(isPrime(sumOfDigits) && isPrime(sumOfSquares))
				count ++;
			i++;
		}
		return count;
	}

	public long getSumOfDigits(long i) {
		long sumOfDigits = 0;
		while (i > 0) {
			sumOfDigits = sumOfDigits + i % 10;
			i = i / 10;
		}
		return sumOfDigits;
	}
	
	public long getSumOfSquareOfDigits(long i) {
		long sumOfDigits = 0;
		while (i > 0) {
			long j = i % 10;
			sumOfDigits = sumOfDigits + j*j ;
			i = i / 10;
		}
		return sumOfDigits;
	}
	
	public boolean isPrime(long k){
		if(k==1)
			return false;
		if(k==2)
			return true;
		for(long i=2;i<=Math.sqrt(k);i++){
			if(k%i == 0)
				return false;
		}
		return true;
		
	}
	public static void main(String[] args) {
		LuckyNumber ln = new LuckyNumber();
		/*long j = ln.getSumOfSquareOfDigits(15);
		boolean b = ln.isPrime(6);*/
		long i = ln.solution(487162823133062956L, 681177519744583339L);
		System.out.println(i);
	}

}
