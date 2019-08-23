package com.debs.sample;

public class RemoveDuplicates {
	
	public int removeDuplicates(int a[]){
		int i = 1;
		if(a == null)
			return 0;
		else if(a.length == 0 || a.length == 1)
			return a.length;
		else{
			for(int j=1;j<a.length; j++){
				if(a[j] != a[j-1]){
					a[i]= a[j];
					i++;
				} else {
					System.out.println("Duplicate entries : " + a[j]);
				}
			}
		}
		if(i< a.length) a[i]=0;
		return i;
	}
	
	public void removeDuplicatesConstantSpace(int[] a){
		int n = a.length;
		for(int i=0;i<n;i++){
			if (a[Math.abs(a[i])] >= 0) 
                a[Math.abs(a[i])] = -a[Math.abs(a[i])]; 
            else
                System.out.print(Math.abs(a[i]) + " "); 
		}
	}
	
	public static void main(String[] args) {
		 int[] a = {1,1,2,2,2,3,3,3,3,4};
		 RemoveDuplicates rd = new RemoveDuplicates();
		 int i = rd.removeDuplicates(a);
		 System.out.println("total non duplicate items : " + i);
	}

}
