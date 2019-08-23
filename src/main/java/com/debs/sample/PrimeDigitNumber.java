package com.debs.sample;

public class PrimeDigitNumber {
	
	public boolean isPrimeDigitNumber(Integer num){
		return isPrimeNumber(num) && areDigitsPrime(num);
	}

	
	private boolean areDigitsPrime(Integer num){
		while(num >0){
			int digit = num % 10;
			if(digit == 4 || digit == 6 || digit ==8 || digit ==9)
				return false;
			num = num/10;
		}
		return true;
	}
	
	private boolean isPrimeNumber(Integer num){
		for(int i=2;i< Math.sqrt(num); i++){
			if(num%i == 0){
				return false;
			}
		}
		return true;
	}
	
	
	
	public static void main(String[] args) {
		PrimeDigitNumber pdn = new PrimeDigitNumber();
		boolean flag = pdn.isPrimeDigitNumber(313);
		System.out.println(flag);
	}

}
