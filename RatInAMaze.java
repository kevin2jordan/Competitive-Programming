import com.sun.javafx.sg.prism.GrowableDataBuffer;

public class RatInaMaze {

    public static void main(String[] args) {
        int[][] grid = {{ 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 }};

        solve(grid);
    }
    private static void solve(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sol = new int[n][m];
        if(solveMazeUtil(grid,0,0,sol)){
            printSolution(sol);
        } else{
            System.out.print("No solution exist");
        }
    }

    private static boolean solveMazeUtil(int[][] grid, int x, int y, int[][] sol) {
        int n = grid.length;
        int m = grid[0].length;
        if(x==n-1 && y==m-1){
            sol[x][y] = 1;
            return true;
        }
        int[]row = {1,0};
        int[]col = {0,1};

        if(isValid(grid, sol,x,y)){
            sol[x][y] = 1;
            for(int k=0;k<row.length;k++){
                if(solveMazeUtil(grid,x+row[k],y+col[k], sol)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int[][] grid, int[][]sol, int x, int y){
        int n = grid.length;
        int m = grid[0].length;

        return x>=0 && x<n && y>=0 && y<m && grid[x][y]==1 && sol[x][y] == 0;
    }
    private static void printSolution(int[][] sol) {
        for(int[] arr : sol) {
            for(int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
