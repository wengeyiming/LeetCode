package searchA2DMatrix74;

public class test {

	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,50}};
		System.out.println(searchMatrix(matrix, 7));
	}
	
    public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
        	return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        
        int left = 0;
        int right = m*n-1;
        while(left <= right) {
        	
        	int middle = (left+right)/2;
        	int mid =  matrix[middle/n][middle%n]; 
        	//System.out.println(left+" "+middle+" "+right);
        	if(mid == target) {
        		return true;
        	} else if(mid > target) {
        		right = middle-1;       		
        	} else {
        		left = middle+1;
        	}
        	//System.out.println(left+" "+middle+" "+right);
        	//System.out.println("");
        }
    	    	
    	return false;
    }
}
