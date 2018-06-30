package queueReconstructionbyHeight406;

import java.util.*;
public class test {
	public static void main(String[] args) {
		int[][] people = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};		
		int[][] res = reconstructQueue(people);
		for(int i=0; i<res.length; i++) {
			for(int j=0; j<res[0].length; j++) {
				System.out.print(res[i][j]+" ");
			}
			System.out.println("");
		}
		
	}
	
    public static int[][] reconstructQueue(int[][] people) {
        if(people == null || people.length == 0) return new int[0][0];   	
    	      
        Arrays.sort(people, new Comparator<int[]>() {
        	public int compare(int[] a, int[] b) {
        		if(b[0] == a[0]) return a[1]-b[1];
        		return b[0] - a[0];
        	}
        });
		for(int i=0; i<people.length; i++) {
			for(int j=0; j<people[0].length; j++) {
				System.out.print(people[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("");
		System.out.println("");
		
        List<int[]> queue = new LinkedList<int[]>();
        for (int[] person : people){
        	queue.add(person[1], person);
        	
        }
        return queue.toArray(new int[people.length][2]);
    }
}
