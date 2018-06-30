package insertInterval57;

import java.util.*;
public class test {
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(3,5));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		
		Interval newInterval = new Interval(4,8);
		
		List<Interval> result = insert(intervals, newInterval);
		
		for(Interval l : result) {
			System.out.print(l.start+","+l.end+"  ");
		}
	}
	
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null || intervals.size() == 0) {
        	ArrayList<Interval> res = new ArrayList<>();
        	res.add(newInterval);
        	return  res;
        } 
        
    	int[] start = new int[intervals.size()+1];
    	int[] end = new int[intervals.size()+1];
    	for(int i=0; i<intervals.size(); i++) {
    		start[i] = intervals.get(i).start;
    		end[i] = intervals.get(i).end;
    	}
    	start[intervals.size()] = newInterval.start;
    	end[intervals.size()] = newInterval.end;
    	Arrays.sort(start);
    	Arrays.sort(end);
    	
    	
    	List<Interval> result = new ArrayList<>();
    	int num=1;
    	int startRecord = start[0];
    	int endRecord = end[0];
    	while(num<start.length) {
        	int nowStart = start[num];
        	int nowEnd = end[num];	
        	if(endRecord < nowStart) {
        		result.add(new Interval(startRecord,endRecord));
        		startRecord = nowStart;
        		endRecord = nowEnd;         		 
        		if(num == start.length-1) {
            		result.add(new Interval(startRecord,endRecord));        			
        		}
        	} else {
        		endRecord = nowEnd;
        		if(num == start.length-1) {
            		result.add(new Interval(startRecord,endRecord));        			
        		}
        	}      	
    		
        	num++;
    	}
    	return result;        
    }
}

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}