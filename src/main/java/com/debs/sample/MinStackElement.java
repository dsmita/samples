package com.debs.sample;

public class MinStackElement {
	Integer value;
	Integer min;
	
	public MinStackElement(Integer x) {
		this.value = x;
		this.min = x;
	}
	
	public MinStackElement(Integer value, Integer min) {
		this.value = value;
		this.min = min;
	}
	
	public void setMin(Integer x){
		this.min=x;
	}

}
