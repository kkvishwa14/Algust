package com.algo.kk.arrays;

public class FirstMissingPositive {
	static int segregateNegatives(int arr[]) {
		int j = 0, temp = 0, size = arr.length;

		for (int i = 0; i < size; i++) {
			if (arr[i] <= 0) {
				temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j++;
			}
		}

		return j;
	}

	static int findMissingPositive(int arr[], int start) {
		int size = arr.length;
		if(start>=size){
			return 1;
		}
		int index = 0;
		for (int i = start; i < size; i++) {
			index = Math.abs(arr[i]) - 1;
			if (index < size && arr[index] > 0)
				arr[index] = -arr[index];
		}

		for (int i = start; i < size; i++) {
			if (arr[i] > 0) {
				return i+1-start;
			}
		}

		return size+1;
	}

	public static int firstMissingPositive(int[] nums) {

		int start = segregateNegatives(nums);
		System.out.println(start);
		return findMissingPositive(nums, start);

	}

	public static void main(String[] args) {
		//int a[] = {1,2,0};
		//System.out.println(firstMissingPositive(a));
		
		//int b[] = {0};
		//System.out.println(firstMissingPositive(b));
		
		//int c[] = {0,1};
		//System.out.println(firstMissingPositive(c));
		
		int d[] = {1000,-1};
		System.out.println(firstMissingPositive(d));

		//int e[] = {};
		//System.out.println(firstMissingPositive(e));
	}

}
