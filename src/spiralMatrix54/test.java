package spiralMatrix54;

//按照顺时针方向螺旋读取矩阵里的数字，是一道非常经典的算法题
import java.util.*;
public class test {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		List<Integer> list = spiralOrder(matrix);
		
		for(Integer n : list) {
			System.out.print(n + " ");
		}
	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		if(matrix == null || matrix.length == 0) return new ArrayList<Integer>();
		
		List<Integer> list = new ArrayList<>();
		//读取方向。1代表右，2代表下，3代表左，4代表上
        int direction = 1;
		//重点是判断截止条件
        int num = matrix.length * matrix[0].length;        
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int now = 0;
        while(now < num) {
        	if(direction == 1) {
        		for(int i=left; i<=right; i++) {
        			list.add(matrix[top][i]);
        			now++;
        		}
        		top++;
        		direction = 2;
        	} else if(direction == 2) {
        		for(int i=top; i<=bottom; i++) {
        			list.add(matrix[i][right]);
        			now++;
        		}
        		right--;
        		direction = 3;
        	} else if(direction == 3) {
        		for(int i=right; i>=left; i--) {
        			list.add(matrix[bottom][i]);
        			now++;
        		}
        		bottom--;
        		direction = 4;
        	} else {
        		for(int i=bottom; i>=top; i--) {
        			list.add(matrix[i][left]);
        			now++;
        		}
        		left++;
        		direction = 1;
        	}      	
        	//System.out.println("top: " + top + " , bottom: " + bottom + " , left: " + left + " , right: " + right);
        }
		
		return list;
    }
}
