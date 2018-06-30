package sortColors75;

import java.util.Arrays;

//一遍排序，且只用O(1)的额外空间。
//顺便复习一下计数排序
public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{0,2,3,1,2,3,0,3,1};

		sortColors(nums);
		for(int m : nums) {
			System.out.print(m+" ");
		}
		System.out.println("");	
		
	}
	
    public static void sortColors(int[] nums) {
    	
    	int zeroPoint = 0;
    	int onePoint = 0;
    	int twoPoint = 0;
        for(int i=0; i<nums.length; i++) {
        	int m = nums[i];
        	nums[i] = 3;
        	if(m < 3) {
        		nums[twoPoint] = 2;
        		twoPoint++;
        		if(m < 2) {
            		nums[onePoint] = 1;
            		onePoint++;
	        		if(m == 0) {
	        			nums[zeroPoint] = 0;
	        			zeroPoint++;
	        		}
        		}
         	}      	
        } 	
    	/*
    	int zeroPoint = 0;
    	int onePoint = 0;
        for(int i=0; i<nums.length; i++) {
        	int m = nums[i];
        	nums[i] = 2;
        	if(m < 2) {
        		nums[onePoint] = 1;
        		onePoint++;
        		if(m == 0) {
        			nums[zeroPoint] = 0;
        			zeroPoint++;
        		}
         	}      	
        }  
        */ 	
    	/*
        int tmp = 0, low = 0, mid = 0, high = nums.length - 1;       
        while(mid <= high)
        {
            if(nums[mid] == 0)
            {
                tmp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = tmp;
                low++;
                mid++;
            }
            else if(nums[mid] == 1)
            {
                mid++;
            }
            else if(nums[mid] == 2)
            {
                tmp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = tmp;
                high--;
            }
        }
        */
    	/*
        int p1 = 0, p2 = nums.length - 1, index = 0;
        while (index <= p2) {
            if (nums[index] == 0) {
                nums[index] = nums[p1];
                nums[p1] = 0;
                p1++;
            }
            if (nums[index] == 2) {
                nums[index] = nums[p2];
                nums[p2] = 2;
                p2--;
                index--;
            }
            index++;
            for(int i=0; i<nums.length; i++) {
            	System.out.print(nums[i]+" ");
            }
            System.out.println("");
        }
        */
    	/*

        */
    }	
}
