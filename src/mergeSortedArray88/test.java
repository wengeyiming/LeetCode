package mergeSortedArray88;

public class test {
	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,3,0,0,0,0};
		int[] nums2 = new int[]{2,5,6};
		
		merge(nums1, 3, nums2, 3);
	}
	
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
    	int[] nums3 = new int[m+n];
    	
    	int num=0,j=0,k=0;
    	while(j<m && k <n) {
    		if(nums1[j] <= nums2[k]) {
    			nums3[num] = nums1[j];
    			j++;
    		} else {
    			nums3[num] = nums2[k];
    			k++;
    		}
    		num++;
    	}
    	while(j<m) {
    		nums3[num] = nums1[j];
    		j++;
    		num++;
    	}
    	while(k<n) {
			nums3[num] = nums2[k];
			k++;
			num++;
    	}
    	
    	
    	for(int i=0; i<nums3.length; i++) {
    		nums1[i] = nums3[i];
    	}

    }	
}
