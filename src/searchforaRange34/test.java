package searchforaRange34;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{8,8,8};
		int target = 8;
		int[] result = searchRange(nums, target);
		
		for(Integer n : result) {
			System.out.print(n+" ");
		}
		
	}
	
	
	
	
	//这个是比较复杂的方法，因为需要同时找两个边界。
	/*
    public static int[] searchRange(int[] nums, int target) {        
    	int[] result = new int[]{-1,-1};
    	if(nums == null) {
    		return result;
    	}
    	int left = 0;
    	int right = nums.length-1;
    	//这个截止条件注意一下，可能有问题 
    	while(left <= right) {
    		int middle = (right+left)/2;
    		//System.out.println(left+","+middle+","+right);
    		if(nums[middle] > target) {
    			right = middle-1;
    		} else if(nums[middle] < target) {
    			left = middle+1;
    		} else {
    			int l = middle;
    			int r = middle;
    			while(l>0 && nums[l] == nums[l-1]) {
    				l--;
    			} 
    			while(r<nums.length-1 && nums[r] == nums[r+1]) {
    				r++;
    			}
    			result[0]=l;
    			result[1]=r;
    			return result;
    		}   		
    	}
    	
    	return result;
    }	
    */
    //优化的方法是做两次二分查找，分别确定左边界和右边界
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[] {-1, -1};
        }

        return new int[]{leftEdge(nums, target), rightEdge(nums, target)};
    }
    private static int leftEdge(int[] nums, int target) {
        int left  = 0;
        int right = nums.length - 1;
        
        //这个必须为left<right-1，否则当left==right-1时，两者相邻，若right的位置正好等于target,就会陷入死循环。
        //下面的同理，若left的位置正好等于target，就会陷入死循环。
        //同时，因为要找到的是等于target的位置，所以left或者right必须等于mid,而不能对mid加1或者减1
        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid;
            }
            System.out.println("left1: "+left+","+"right1: "+right);
        }
        if (nums[left] == target) {
            return left;
        } else if (nums[right] == target) {
            return right;
        } else {
            return -1;
        }
    }
    private static int rightEdge(int[] nums, int target){
        int left  = 0;
        int right = nums.length - 1;

        while (left + 1 < right) {
            int mid = (right - left) / 2 + left;

            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid;
            }
            System.out.println("left2: "+left+","+"right2: "+right);
        }
        if (nums[right] == target) {
            return right;
        } else if (nums[left] == target) {
            return left;
        } else {
            return -1;
        }
    }
}
