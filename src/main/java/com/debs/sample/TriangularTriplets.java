package com.debs.sample;

public class TriangularTriplets {

	public void findTriangularTriplets(int[] arr) {
		mergeSort(arr);
		for (int m = 0; m < arr.length; m++) {
			System.out.println("sorted array " + m + " element : " + arr[m]);
		}
		int length = arr.length;
		int leastPerimeter = 0, perimeter = 0;
		
		for(int i=0; i<length-2; i++){
			for(int j= i+1; j<length -1; j++){
				int k = j+1;
				while (k<length){
					if (arr[i] + arr[j] > arr[k]) {
						perimeter = arr[i] + arr[j] + arr[k];
						System.out.println("triangular triplets : " + arr[i] +":" + arr[j] + ":" + arr[k]);
						if (leastPerimeter != 0 && leastPerimeter > perimeter)
							leastPerimeter = perimeter;
						else if (leastPerimeter == 0)
							leastPerimeter = perimeter;
					} else if (arr[i] + arr[j] < arr[k])
						break;
					k++;
				}
			}
			
		}
		System.out.println("leastPerimeter " + leastPerimeter);
	}

	public void mergeSort(int[] arr) {
		if (arr.length < 2)
			return;

		int length = arr.length;
		int[] left = new int[length / 2];
		int[] right = new int[length - left.length];

		/* Copy data to temp arrays */
		for (int p = 0; p < length / 2; p++)
			left[p] = arr[p];
		for (int q = 0; q < right.length; q++)
			right[q] = arr[right.length + q];

		mergeSort(left);
		mergeSort(right);
		merge(arr, left, right);
		return;
	}

	private void merge(int[] arr, int[] first, int[] second) {
		int iFirst = 0;
		int iSecond = 0;
		int j = 0;

		while (iFirst < first.length && iSecond < second.length) {
			if (first[iFirst] <= second[iSecond]) {
				arr[j] = first[iFirst];
				iFirst++;
				j++;
			} else {
				arr[j] = second[iSecond];
				iSecond++;
				j++;
			}
		}

		// copy elements those are missing
		while (iFirst < first.length) {
			arr[j] = first[iFirst];
			iFirst++;
			j++;
		}

		while (iSecond < second.length) {
			arr[j] = second[iSecond];
			iSecond++;
			j++;
		}
	}

	public static void main(String[] args) {
		TriangularTriplets tt = new TriangularTriplets();
		int[] arr = { 4, 10, 5, 3, 6, 8, 1, 2 };
		tt.findTriangularTriplets(arr);
	}

}
