package numberof1Bits191;

public class test {
	public static void main(String[] args) {
		System.out.println(hammingWeight(128));
	}
	
    public static int hammingWeight(int n) {
    	
        int num = 0;
        while(n > 0) {
        	if((n&1) != 0) {
        		num++;
        	}
        	//>>>�����޷�����λ��һ�ɲ�0�� >>�����з�����λ��������0������1
        	n = n>>>1;
        }
        return num;
    }
}
