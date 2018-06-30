package spiralMatrixTwo59;


public class test {
	public static void main(String[] args) {
		
		int[][] matrix = generateMatrix(0);		
		for(int i=0; i<matrix.length; i++) {
			for(int j=0; j<matrix[0].length; j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println("");
		}
	}
	
    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
		//读取方向。1代表右，2代表下，3代表左，4代表上
        int direction = 1;
        int now=1; 
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        while(now <= n*n) {
           	if(direction == 1) {
        		for(int i=left; i<=right; i++) {
        			matrix[top][i] = now;
        			now++;
        		}
        		top++;
        		direction = 2;
        	} else if(direction == 2) {
        		for(int i=top; i<=bottom; i++) {
        			matrix[i][right] = now;
        			now++;
        		}
        		right--;
        		direction = 3;
        	} else if(direction == 3) {
        		for(int i=right; i>=left; i--) {
        			matrix[bottom][i] = now;
        			now++;
        		}
        		bottom--;
        		direction = 4;
        	} else {
        		for(int i=bottom; i>=top; i--) {
        			matrix[i][left] = now;
        			now++;
        		}
        		left++;
        		direction = 1;
        	}          	
        }        
    	return matrix;
    }
}
