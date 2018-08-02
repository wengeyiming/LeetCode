package fractiontoRecurringDecimal166;

import java.util.*;

public class test {
	public static void main(String[] args) {
		System.out.println(fractionToDecimal(2, 7));
	}

	public static String fractionToDecimal(int numerator, int denominator) {
		if (numerator == 0) {
			return "0";
		}
		StringBuilder sb = new StringBuilder("");
		sb.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        // integral part
        sb.append(num / den);
        
        num %= den;
        if(num == 0) {
        	return sb.toString();
        }
        
        sb.append(".");
        HashMap<Long, Integer> map = new HashMap<>();
        map.put(num, sb.length());
        
        while(num != 0) {
        	num *= 10;
        	sb.append(num/den);
        	num %= den;
        	if(map.containsKey(num)) {
        		System.out.println(map.get(num));
        		sb.insert(map.get(num), "(");
        		
        		sb.append(')');
        		
        		break;
        	} else {
        		map.put(num, sb.length());
        	}
        }
        
		return sb.toString();
	}
}
