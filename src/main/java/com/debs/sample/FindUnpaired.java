package com.debs.sample;

public class FindUnpaired {

	public int solution(int[] A) {
		mergeSort(A, 0, A.length - 1);
		int unpaired = findUnpaired(A);
		System.out.println("unpaired"+ unpaired);
		return unpaired;
	}

	public int findUnpaired(int[] A) {
		int unpaired = 0;
		int count =0;
		for (int i = 0; i < A.length - 2; i = i + 2) {
			if (A[i] == A[i + 1]){
				count = count+2;
				continue;
			}
			else {
				unpaired = A[i];
				break;
			}
		}
		if(count == A.length -1)
			unpaired = A[A.length-1];
		return unpaired;
	}

	void merge(int arr[], int l, int m, int r) {
		int i, j, k;
		int n1 = m - l + 1;
		int n2 = r - m;

		/* create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays L[] and R[] */
		for (i = 0; i < n1; i++)
			L[i] = arr[l + i];
		for (j = 0; j < n2; j++)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays back into arr[l..r] */
		i = 0; // Initial index of first subarray
		j = 0; // Initial index of second subarray
		k = l; // Initial index of merged subarray
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/*
		 * Copy the remaining elements of L[], if there are any
		 */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/*
		 * Copy the remaining elements of R[], if there are any
		 */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	/*
	 * l is for left index and r is right index of the sub-array of arr to be
	 * sorted
	 */
	void mergeSort(int arr[], int l, int r) {
		if (l < r) {
			// Same as (l+r)/2, but avoids overflow for
			// large l and h
			int m = l + (r - l) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			merge(arr, l, m, r);
		}
	}
	
	public static void main(String[] args) {
		FindUnpaired fu = new FindUnpaired();
		int A[]= new int[5];
		A[0]=2;
		A[1]=2;
		A[2]=3;
		A[3]=3;
		A[4]=4;
		fu.mergeSort(A, 0, 4);
//		int unpaired = fu.findUnpaired(A);
		for(int i=0;i<5;i++)
			System.out.println(A[i]+"#######");
	}

}
