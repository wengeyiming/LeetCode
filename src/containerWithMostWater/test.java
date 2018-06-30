package containerWithMostWater;


//�Ա�84�⣬������������Ǹ�Ҫ���������м䲻�ܶϡ�������Զϡ�
public class test {
	public static void main(String[] args) {
		int[] height = new int[]{10};
		System.out.println(maxArea(height));
	}
	
    public static int maxArea(int[] height) {
        int max = 0;
        int area = 0;
        int i=0;
        int j=height.length-1;
        while(i!=j) {
        	if(height[i]>=height[j]) {
        		area = (j-i)*height[j];
        		j--;
        	} else {
        		area = (j-i)*height[i];
        		i++;
        	}
        	if(area > max) {
        		max = area;
        	}
        }
        
        return max;
    }
}
