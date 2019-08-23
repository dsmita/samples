package com.debs.sample;

public class SubArraySum {
	
	public int[] solution(int arr[], int n, int sum) {
		int curr_sum=0, start_index=0, end_index=0;
		int [] indexToBereturned = new int[2];
		while(start_index <n-1 && end_index <n){
			if(curr_sum == sum){
				indexToBereturned[0] = start_index;
				indexToBereturned[1] = end_index -1;
				return indexToBereturned;
			}
			else if(curr_sum<sum){
				curr_sum = curr_sum+arr[end_index];
				end_index++;
			} else if(curr_sum > sum){
				curr_sum = curr_sum-arr[start_index];
				start_index ++;
			}
			
		}
		return indexToBereturned;
	}

	
	public static void main(String[] args) {
		SubArraySum sas = new SubArraySum();
		int [] arr = {1, 4, 20, 3, 10, 5};
		int [] index = sas.solution(arr,6,33);
		System.out.println("start index : " +index[0] );
		System.out.println("end index : " +index[1] );
	}
}
