package KthLargestElementinanArray215;

import java.util.*;

public class test {
	public static void main(String[] args) {

		int[] nums = new int[] { 3, 2, 3, -1, -2, 4, 5, 5, 6 };
		System.out.println(findKthLargest(nums, 1));
	}

	/*
	public static int findKthLargest(int[] nums, int k) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int n : nums) {
			if (n >= max)
				max = n;
			if (n <= min)
				min = n;
		}

		// System.out.println(min + " " + max);
		int[] bucket = new int[max - min + 1];

		for (int n : nums) {
			bucket[n - min]++;
		}

		int res = 0;
		int total = 0;
		for (int i = bucket.length - 1; i >= 0; i--) {
			if (bucket[i] != 0) {
				total += bucket[i];
				if (total >= k) {
					res = i + min;
					break;
				}
			}
		}
		return res;
	}
	*/
	
	//QuickSelect
	public static int findKthLargest(int[] a, int k) {
		int n = a.length;
		int p = quickSelect(a, 0, n - 1, n - k );
		return a[p];
	}

	// return the index of the kth smallest number
	private static int quickSelect(int[] a, int lo, int hi, int k) {
		int left = lo, pivot = a[hi];
		
		for(int i=lo; i<hi; i++) {
			if(a[i] <= pivot) {
				swap(a,left++,i);
			}
		}
		swap(a,left,hi);
		
		if(left == k) return left;
		else if(left < k) {
			return quickSelect(a,left+1, hi, k);
		} else {
			return quickSelect(a,lo, left-1, k);
		}
	}
	
	private static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
}
