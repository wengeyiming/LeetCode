package palindromeNumber9;
import java.util.*;


//尝试不要把数字换成字符串来解决
public class test {
	
	public static void main(String[] args) {
		System.out.println(isPalindrome(1001));
	}
	
    public static boolean isPalindrome(int x) {
        if(x<0 || (x!=0 &&x%10 == 0)) return false;
        else if(x>=0 && x<10) return true;
        int rev = 0;
        while (x>rev){
        	rev = rev*10 + x%10;
        	x = x/10;
            System.out.println(x+","+rev);
        }

        return (x==rev || x==rev/10);

    }
}
