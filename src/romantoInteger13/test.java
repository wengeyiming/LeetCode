package romantoInteger13;

public class test {
	public static void main(String[] args) {
		System.out.println(romanToInt(new String("LVIIIV")));
	}
	
    public static int romanToInt(String s) {
    	
        char[] c = s.toCharArray();
        int sum = 0;
        
        for(int i=0; i<c.length; i++) {
        	if(c[i] == 'I') {
        		if(i != c.length-1) {
        			if(c[i+1] == 'V') {
        				sum += 4;
        				i++;
        			} else if(c[i+1] == 'X') {
        				sum += 9;
        				i++;
        			} else {
        				sum += 1;
        			}
        		} else {
        			sum += 1;
        		}
        	} else if(c[i] == 'X') {
        		if(i != c.length-1) {
        			if(c[i+1] == 'L') {
        				sum += 40;
        				i++;
        			} else if(c[i+1] == 'C') {
        				sum += 90;
        				i++;
        			} else {
        				sum += 10;
        			}
        		} else {
        			sum += 10;
        		}
        	} else if(c[i] == 'C') {
        		if(i != c.length-1) {
        			if(c[i+1] == 'D') {
        				sum += 400;
        				i++;
        			} else if(c[i+1] == 'M') {
        				sum += 900;
        				i++;
        			} else {
        				sum += 100;
        			}
        		} else {
        			sum += 100;
        		}
        	} else if(c[i] == 'V') {
        		sum += 5;
        	} else if(c[i] == 'L') {
        		sum += 50;
        	} else if(c[i] == 'D') {
        		sum += 500;
        	} else if(c[i] == 'M') {
        		sum += 1000;
        	}
        }
        
        return sum;
    }

}
