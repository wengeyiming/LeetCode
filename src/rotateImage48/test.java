package rotateImage48;

//˳ʱ���ƶ����顣�����ȶԳƱ任
public class test {
	public static void main(String[] args) {
		//int[][] image = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		int[][] image = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		rotate(image);
	}
	
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
    	
        for(int i=0; i<n; i++) {
        	for(int j=0; j<i; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[j][i];
        		matrix[j][i] = temp;
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n/2; j++) {
        		int temp = matrix[i][j];
        		matrix[i][j] = matrix[i][n-1-j];
        		matrix[i][n-1-j] = temp;
        	}
        }
        
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		System.out.print(matrix[i][j]+ " ");
        	}
        	System.out.println("");
        }
    }	
}
