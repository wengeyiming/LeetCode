package maximalSquare221;


public class test {
	public static void main(String[] args) {
		char[][] matrix = new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},
			{'1','1','1','1','1'},{'1','0','0','1','0'}};
		System.out.println(maximalSquare(matrix));
	}
	
    public static int maximalSquare(char[][] matrix) {
        int size = 0;
        boolean fits = true;
        while(fits){
            size++;
            fits = squareWorks(matrix, size);
            
        }
        size--;
        return size * size;
    }
    public static boolean squareWorks(char[][] matrix, int size){
        if(size > matrix.length || size > matrix[0].length){
            return false;
        }
        for(int i = 0; i <= matrix.length - size; i++){
            for(int j = 0; j <= matrix[0].length - size; j++){
                if(ones(matrix,i,j,size))
                    return true;
            }
        }
        return false;
    }
    public static boolean ones(char[][] matrix, int x, int y, int size){
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                if(matrix[x+i][y+j] == '0')
                    return false;
            }
        }
        return true;
    }
	
	/*
    public static int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length, result = 0;
        int[][] b = new int[m+1][n+1];
        for (int i = 1 ; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(matrix[i-1][j-1] == '1') {
                    b[i][j] = Math.min(Math.min(b[i][j-1] , b[i-1][j-1]), b[i-1][j]) + 1;
                    result = Math.max(b[i][j], result); // update result
                }
            }
        }
        
        for(int i=0; i<b.length; i++) {
        	for(int j=0; j<b[0].length; j++) {
        		System.out.print(b[i][j] +" ");
        	}
        	System.out.println("");
        }
        return result*result;
    }
    */
}
