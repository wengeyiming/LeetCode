package singleNumberIII260;

public class test {
	public static void main(String[] args) {
		int[] nums = new int[]{1,16,1,3,16,19};
		
		int[] result = singleNumber(nums);
		System.out.println(result[0] + ", " + result[1]);
	}
	
    public static int[] singleNumber(int[] nums) {
    	int AXORB = 0;
    	for(int num : nums) {
    		AXORB ^= num;
    	}
    	
        // pick one bit as flag��������ĺ����ȼ�
        int bitFlag = (AXORB & (~ (AXORB - 1)));
        
        int[] res = new int[2];
        System.out.println(bitFlag);
        for (int num : nums) {
            if ((num & bitFlag) == 0) {
                res[0] ^= num;
            } else {
                res[1] ^= num;
            }
        }
        return res;
    }
    
    //�ҵ�AXORB�д��������һ��1��λ�ã���������λ�û�λ0
    private static int f(int num){
        int times = 0;
        while(num > 0){
            if(num % 2 == 1){
                break;
            }
            times++;
            num = num >> 1;
        }
        
        return 1 << times;
    }
}
