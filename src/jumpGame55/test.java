package jumpGame55;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{5,9,3,2,1,0,2,3,3,1,0,0};

		System.out.println(canJump(nums));

	}
	
    public static boolean canJump(int[] nums) {  
    	//��¼��ǰ�ܵ�������λ��.
    	int pos = 0;
    	for(int i=0; i<nums.length; i++) {
    		if(pos < i) { 
    			return false;
    		}
    		if (nums[i] + i > pos) {
    	        pos = nums[i] + i;
    		}
    		System.out.println(pos);
    	}
    	return true;
    	
    	//����㷨�Ǵ���ģ�����ԭ��Ƚϸ���
    	//�����������Ϊ������һ��������5�����Դ��㷨�ж�ǰ��5����������Զ���ǵڶ�������9�����ߵ�10�����Ǻ�����10ǰ������ּ��Ϻ����10�������
    	//©���жϡ�
    	/*
    	if(nums.length == 1) return true;
    	int max = 0;   	
    	int i=0;
    	int li = 0;
    	while(i<nums.length-1) {
    		max = 0;
			if(i+nums[i] >= nums.length-1) {
				return true;
			}
    		for(int j=0; j<=nums[i]; j++) {
    			if(nums[i+j] + i+j > max) {
    				max = nums[i+j] + i+j;
    			}
    		}
    		i = max;
    		System.out.println("max:  " + max + "   , i: "+i);
    		if(max <= 0) {
    			return false;
    		} 

    		if(i == li) {
    			return false;
    		}
    		li = i;
    	}
    	
    	return true;
    	*/
    }	
}
