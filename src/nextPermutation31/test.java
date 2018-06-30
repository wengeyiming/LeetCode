package nextPermutation31;

//就是实现字典序算法. 正序没思路的时候，尝试倒序
import java.util.*;
public class test {	
	public static void main(String[] args) {
		int[] nums = new int[]{5,4,3,2,1};
		nextPermutation(nums);
		for(int i=0; i<nums.length; i++) {
			System.out.print(nums[i] + " ");
		}
	}
	
    public static void nextPermutation(int[] nums) {
    	if(nums.length <=1 ) return;
    	int j = 0;
    	int temp = 0;
    	boolean descent = true;
        for(int i=nums.length-1; i>=1; i--) {
        	if(nums[i] <= nums[i-1]) {
        		continue;
        	} else {
        		descent = false;

        		j = i-1;
        		for(int m=nums.length-1; m>=j; m--) {
        			if(nums[m] > nums[j]) {
        				temp = nums[m];
        				nums[m] = nums[j];
        				nums[j] = temp;
        				break;
        			}
        		}
        		int o = nums.length-1;
        		for(int p=j+1; p<=o; p++) {
    				temp = nums[p];
    				nums[p] = nums[o];
    				nums[o] = temp;
        			o--;
        		}
        		break;
        	}
        	
        }
        if(descent) {
    		int o = nums.length-1;
    		for(int p=0; p<=o; p++) {
				temp = nums[p];
				nums[p] = nums[o];
				nums[o] = temp;
    			o--;
    		}
        }
    }

}
