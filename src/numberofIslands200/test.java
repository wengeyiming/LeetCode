package numberofIslands200;

public class test {
	public static void main(String[] args) {
		char[][] grid = new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},
			{'0','0','0','1','1'}};
		System.out.println(numIslands(grid));
	}
	
    public static int numIslands(char[][] grid) {
        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }
        return count;
    	/*建立visit数组代表一个节点是否被访问过也可以，不过略麻烦，不如直接在原数组上改
    	if(grid == null || grid.length == 0) return 0; 
        int count = 0;
        int row = grid.length;
        int column = grid[0].length;                      
        return count;
        */
    }
    
    public static void dfs(char[][] grid, int row, int col) {
    	if(row>=0 && col>=0 && row<grid.length && col < grid[0].length && grid[row][col] == '1') {
    		grid[row][col] = '0';
    		dfs(grid, row-1, col);
    		dfs(grid, row, col-1);
    		dfs(grid, row+1, col);
    		dfs(grid, row, col+1);
    	}
    }
}
