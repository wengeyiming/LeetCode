package happyNumber202;

import java.util.*;
public class test {
	public static void main(String[] args) {
		System.out.println(isHappy(119));
	}
	
    public static boolean isHappy(int n) {
        int num = n;
        HashMap<Integer, Boolean> map = new HashMap<>();
        while(num != 1) {
        	if(map.containsKey(num)) {
        		return false;
        	}
        	map.put(num, true);
        	int temp = 0;
        	while(num != 0) {
        		temp += (num%10)*(num%10);
        		num = num/10;
        	}        	

        	num = temp;       	      	
        }
    	   	
    	return true;
    }
}
