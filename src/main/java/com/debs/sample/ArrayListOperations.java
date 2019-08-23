package com.debs.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ArrayListOperations {

	public Integer continousSubArraysum2(int[] arr) {
		Integer sumSoFar = 0, maxSum = 0, startIndex = 0, endIndex = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= sumSoFar + arr[i]) {
				sumSoFar = sumSoFar + arr[i];

			} else if (arr[i] > sumSoFar + arr[i]) {
				sumSoFar = arr[i];
				startIndex = i;
			}
			if (sumSoFar > maxSum) {
				maxSum = sumSoFar;
				endIndex = i;
			}
		}
		System.out.println("StartIndex : " + startIndex + " EndIndex : " + endIndex + " Sum : " + maxSum);
		return maxSum;
	}
	
	public Integer continousSubArraySum(int[] arr){
		Integer maxTillNow =0, maxSum =0;
		
		for(int i=0;i<arr.length;i++){
			maxTillNow = arr[i]+maxTillNow;
			if(maxTillNow < 0)
				maxTillNow =0;
			maxSum = Math.max(maxSum, maxTillNow);
		}
		return maxSum;
	}
	
	public int maxSubArray(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums.length == 1)
            return nums[0];
        int maxSum=nums[0], maxTillNow =nums[0];
        for(int i=1;i<nums.length;i++){
            maxTillNow = Math.max(nums[i], maxTillNow+nums[i]);
            maxSum = Math.max(maxTillNow, maxSum);
        }
      return maxSum;  
    }

	public ArrayList<String> permutation(String s) {
		ArrayList<String> result = new ArrayList<String>();

		if (s.length() == 1) {
			result.add(s);
		} else if (s.length() > 1) {
			int lastIndex = s.length() - 1;
			String last = s.substring(lastIndex);
			String rest = s.substring(0, lastIndex - 1);

			result = merge(permutation(rest), last);
		}
		return result;
	}

	private ArrayList<String> merge(ArrayList<String> list, String c) {
		ArrayList<String> result = new ArrayList<String>();
		for (String s : list) {
			for (int i = 0; i < s.length(); i++) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				result.add(ps);
			}
		}
		return result;
	}

	public int[] removeDuplicates(int a[]) {
		int j = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != (a[j])) {
				j++;
				a[j] = a[i];
			}
		}

		return a;
	}

	public Set maximumArray(int a[], int b[]) {
		int[] sorteda = mergeSort(a, 0, a.length - 1);
		int[] sortedb = mergeSort(b, 0, b.length - 1);

		int length = (sorteda.length / 2) + (sortedb.length / 2);
		Set c = new HashSet();
		for (int i = 0; i < length / 2; i++) {
			c.add(sorteda[i]);
		}
		for (int j = length / 2 + 1; j < length; j++) {
			c.add(sortedb[j]);
		}
		return c;
	}

	public int[] mergeSort(int a[], int l, int r) {
		int i = 0;
		int j = a.length;
		/*
		 * while(j > i){ divide(i,j); }
		 */

		if (l < r) {
			int m = (l + r) / 2;
			mergeSort(a, l, m);
			mergeSort(a, m + 1, r);
			merge(a, l, m, r);
		}
		return a;
	}

	private int[] divide(int start, int end) {
		int end2 = end;
		if (end > start) {
			end = (end - start) / 2;
		}
		int start2 = end + 1;
		int[] c = new int[4];
		c[0] = start;
		c[1] = end;
		c[2] = start2;
		c[3] = end2;

		return c;
	}

	private void merge(int a[], int l, int m, int r) {
		int i = 0;
		int j = m + 1;
		int k = 0;

		int n1 = m - l;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int p = 0; p < n1; ++p)
			L[p] = a[l + p];
		for (int q = 0; q < n2; ++q)
			R[q] = a[m + 1 + q];

		while (i < (m - l) && j < (r - m - 1)) {
			if (L[i] <= R[j]) {
				a[k] = L[i];
				i++;
			} else {
				a[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			a[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			a[k] = R[j];
			j++;
			k++;
		}
	}

	public Integer maximumNonDuplicatedCharacters(String str) {
		if (str == null)
			return null;
		int length = str.length();
		if (length == 0 || length == 1)
			return length;

		int maxNonDup = 1;

		for (int i = 0; i < length - 1; i++) {
			HashMap<Character, Integer> charMap = new HashMap<Character, Integer>();
			int maxForEachIndex = 1;
			charMap.put(str.charAt(i), i);
			for (int j = i + 1; j < length; j++) {
				if (charMap.containsKey(str.charAt(j))) {
					break;
				}
				maxForEachIndex++;
				charMap.put(str.charAt(j), j);
				maxNonDup = Math.max(maxForEachIndex, maxNonDup);
			}
		}
		return maxNonDup;
	}

	public void printPairsWithSameSum(int[] numbers, int k) {
		if (numbers.length < 2)
			return;
		Arrays.sort(numbers);
		int right = numbers.length - 1;
		int left = 0;

		while (left < right) {
			int sum = numbers[left] + numbers[right];
			if (sum == k) {
				System.out.println(numbers[left] + "  " + numbers[right]);
				left++;
				right--;
			} else if (sum > k)
				right--;
			else
				left++;
		}

	}

	public void rotate(int[] numbers, int k) {
		int n = numbers.length;
		reverse(numbers, 0, k - 1);
		reverse(numbers, k, n - 1);
		reverse(numbers, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.println(numbers[i] + " ");
		}
	}

	public void reverse(int[] numbers, int start, int end) {
		while (start < end) {
			int temp = numbers[start];
			numbers[start] = numbers[end];
			numbers[end] = temp;
			start++;
			end--;
		}
	}

	public void subArrayWithGivenSum(int[] a, int sum) {
		int n = a.length;
		int currSum = 0;
		int[] startEnd = new int[2];
		for (int i = 0; i < n; i++) {
			if (a[i] == sum) {
				startEnd[0] = i;
				startEnd[1] = i;
				break;
			} else {
				currSum = a[i];
				for (int j = i + 1; j < n; j++) {
					if (currSum == sum) {
						System.out.println("Got the sum and i::" + i + " and j :: " + j);
						return;
					}
					if (currSum > sum || j == n)
						break;
					currSum = currSum + a[j];
				}
			}
		}
	}

	public void subArrayWithGivenSumSlidingWindow(int[] a, int sum) {
		int startIndex = 0, n = a.length, currSum = a[0];

		for (int i = 1; i < n; i++) {
			while (currSum > sum && startIndex < i - 1) {
				currSum = currSum - a[startIndex];
				startIndex++;
			}
			if (currSum == sum) {
				System.out.println("Got the sum and startIndex :: " + startIndex + " endIndex :: " + (i - 1));
				return;
			}
			currSum = currSum + a[i];
		}
		System.out.println("No sum found");
		return;
	}
	
	public boolean findNumberInRotatedArray(int[] nums, int target){
		int pivot =  findPivot(nums, 0, nums.length-1);
		return binarySearch(nums,0,pivot,target) || binarySearch(nums,pivot+1,nums.length-1,target);
	}

	private boolean binarySearch(int[] a, int left, int right, int target) {
		if(left<right){
			int mid = (left+right)/2;
			if(a[mid]== target)
				return true;
			else if(a[mid]<target)
				return binarySearch(a, mid+1, right, target);
			else
				return binarySearch(a, left, mid, target);
		}
		return false;
	}

	private int findPivot(int[] a, int left, int right) {
		if(left<right)
			return left;
		if(left==right)
			return left;
		int mid = (left + right)/2;
		if(mid<right && a[mid+1]<a[mid])
			return mid;
		if(mid>left && a[mid-1]>a[mid])
			return mid-1;
		if(a[left]>a[mid]){
			
			return findPivot(a,left, mid);
		} 
			return findPivot(a, mid+1, right);
	}

	public boolean isomorphicStrings(String a,String b){
		Map<Character,Character> map = new HashMap<Character,Character>();
		Set<Character> set = new HashSet<Character>();
		int m = a.length();
		int n= b.length();
		if(m!=n)
			return false;
		for(int i=0;i<m;i++){
			Character p = a.charAt(i);
			Character q = b.charAt(i);
			if(map.containsKey(p)){
				if(!map.get(p).equals(q))
					return false;
			} else{
				if(set.contains(q)){
					return false;
				}
				map.put(p, q);
				set.add(q);
			}
		}
		return true;
	}
	
	public List<List<String>> groupAnagrams(String[] strs){
		HashMap<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		for(String s:strs){
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String key = String.valueOf(ca);
			if(anagramMap.containsKey(key)){
				List<String> list = anagramMap.get(key);
				list.add(s);
				anagramMap.put(key, list);
			} else{
				List<String> list = new ArrayList<>();
				list.add(s);
				anagramMap.put(key, list);
			}
			
		}
		return new ArrayList(anagramMap.values());
	}
	
	public List<List<String>> groupAnagrams2(String[] strs){
		HashMap<String, List<String>> anagramMap = new HashMap<String, List<String>>();
		int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()){
            	count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!anagramMap.containsKey(key)){
            	anagramMap.put(key, new ArrayList());
            }
            anagramMap.get(key).add(s);
        }
        return new ArrayList(anagramMap.values());
	}
	
	public double pow(double x, int n) {
		double result = 1, max = Double.MAX_VALUE, min = Integer.MIN_VALUE;
		if (n > 0) {
			while (/*min < result && result < max &&*/ n > 0) {
				result = result * x;
				n--;
			}
			return result;
		}
		if (n < 0) {
			while (min < result && result < max && n < 0) {
				result = result /x;
				n++;
			}
			return result;
		}
		return result;
	}
	
	public int[] toBinary(int n){
		int[] binary = new int[30];
		int index=0;
		while(n>0){
			binary[index]= n%2;
			n=n/2;
			index++;
		}
		return binary;
	}
	
	public String toHexaDecimal(int n){
		char[] hexArr = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		int rem =0;
		String result = "";
		while(n>0){
			rem = n%16;
			result = result+hexArr[rem];
			n=n/16;
		}
		return result;
	}
	
	public int[] productOfArrayExceptSelf(int[] a){
		int n= a.length;
		int[] left= new int[n];
		int[] right= new int[n];
		int[] product= new int[n];
		
		left[0]=1;
		right[n-1]=1;
		for(int i=1;i<n;i++){
			left[i]= left[i-1]*a[i-1];
		}
		
		for(int i=n-2;i>=0;i--){
			right[i]=right[i+1]*a[i+1];
		}
		
		for(int i=0;i<n;i++){
			product[i]=left[i]*right[i];
		}
		return product;
	}
	
	 // https://www.geeksforgeeks.org/find-the-element-before-which-all-the-elements-are-smaller-than-it-and-after-which-all-are-greater-than-it/
	public int getElementBeforeWhichAllElementsAreSmallerAfterWhichAllElementsAreGreater(int[] arr) {
		int n = arr.length;
		int[] max = new int[n];
		int[] min = new int[n];
		max[0] = arr[0];
		for (int i = 1; i < n; i++) {
			max[i] = arr[i] > max[i - 1] ? arr[i] : max[i - 1];
		}
		min[n - 1] = arr[n - 1];
		for (int i = n - 1; i > 0; i++) {
			min[n - 2] = arr[n - 2] < min[n - 1] ? arr[n - 2] : min[n - 1];
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] == min[i] && arr[i] == max[i])
				return arr[i];
		}
		return -1;
	}
	
	public int[] moveZerosToEnd(int[] a){
		int j=0;
		int n=a.length;
		for(int i=0;i<n;i++){
			if(a[i]!=0){
				a[j]=a[i];
				j++;
			}
		}
		
		while(j<n){
			a[j]=0;
			j++;
		}
		return a;
	}
	
	//time complexity - log(n). elements before missing element a[i]-i =1,
	//elements after missing element a[i]-i=2
	public int findMissingElementInSortedArray(int[] a){
		int start=0;
		int end=a.length;
		
		return findMissingElementInSortedArray(a, start, end);
	}
	
	private int findMissingElementInSortedArray(int[] a, int start, int end){
		int mid=0;
		while(end - start > 1){
			mid = (end-start)/2 + start;
			if(a[mid]-mid == 1){
				start=mid;
			} else if(a[mid]-(mid) == 2){
				end=mid;
			}
		}
		return a[mid]+1;
	}
	
	public int stringToInt(String s){
		if(s == null)
			return 0;
		s=s.trim();
		int n = s.length();
		if(n==0)
			return 0;
		double result = 0;
		
		int i=0;
		char flag = '+';
		if (s.charAt(0) == '-') {
			flag='-';
			i++;
		} else if(s.charAt(0) == '+'){
            i++;
        }
		
		while(i<n && s.charAt(i)>'0' && s.charAt(i)<'9'){
			result=(result*10)+(s.charAt(i)-'0');
			i++;
		}
		
		if(flag=='-')
			result = result*(-1);
		if(result >Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if(result<Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		
		return (int) result;
	}
	
	public static void main(String[] args) {
		ArrayListOperations alo = new ArrayListOperations();
		int[] a = { 5, 2, 0, 1, 4, 7, 8,0 };
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		int[] b = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int [] c = {0,0,1,1,1,2,2,3,3,3,4,4};
		/*
		 * int l =0, r=5; alo.mergeSort(a, l, r); for(int i=0;i<6;i++)
		 * System.out.println(a[i]+"#######"); int i =
		 * alo.continousSubArraysum(arr);
		 */
		 /*int i = alo.maximumNonDuplicatedCharacters("abceadfgh");
		 alo.printPairsWithSameSum(a,9);
		 System.out.println(i);
		 alo.rotate(a, 2);
		alo.subArrayWithGivenSumSlidingWindow(b, 17);
		int [] array = alo.removeDuplicates(c);
		int j = alo.continousSubArraySum(arr);
		
		
		double result = alo.pow(-2, 2);
		int[] product = alo.moveZerosToEnd(a);
		 
		int d = Integer.MAX_VALUE+5;
		int[] arr2 = { 1, 2, d, 4 };
		int[] product = alo.productOfArrayExceptSelf(arr2);
		
		for(int i=0;i<product.length;i++){
			System.out.println(product[i]);
		}
		
		int[] d = {1,2,3,4,6,7,8,9};
		int index = alo.findMissingElementInSortedArray(d);
		System.out.println(index);
		*/
		String s= "42";
		int i = alo.stringToInt(s);
		System.out.println(i);
	}
}
