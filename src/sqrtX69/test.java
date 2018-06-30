package sqrtX69;

public class test {
	public static void main(String[] args) {
		System.out.println(mySqrt(2147395599));
	}
	
    public static int mySqrt(int x) {
        if(x == 0) return 0;
     	int left = 1,right = x;
     	while(left <= right) {
     		int mid = (left+right)/2;
     		//这里注意千万不要写成 mid*mid == x，会溢出而且大整数乘法计算也很慢
     		if(mid == x/mid) {
     			return mid;
     		} else if(mid < x/mid) {
     			left = mid+1;
     		} else {
     			right = mid-1;
     		}

     	}
     	
     	return right;
    }	
}
