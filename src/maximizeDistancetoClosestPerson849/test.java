package maximizeDistancetoClosestPerson849;

public class test {
	public static void main(String[] args) {
		int[] seats = new int[]{1,0,0,0,0,0};
		System.out.println(maxDistToClosest(seats));
	}
	
    public static int maxDistToClosest(int[] seats) {
        int max = 0;
        int left = -1;
        for(int i=0; i<seats.length; i++) {
        	if(seats[i] == 1) {
        		if(left == -1) {
        			if(i-left-1 > max) {
        				max = i-left-1;
        			}
        		} else {
        			if((i-left)/2 > max) {
        				max = (i-left)/2;
        			}
        		}
        		left = i;
        	} else {
        		if(i == seats.length - 1) {
        			if((i-left) > max) {
        				max = (i-left);
        			}
        		}
        		continue;
        	}       	       	
        }
        
        return max;
    }
}
