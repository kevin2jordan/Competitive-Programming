public class RatInAMaze {

    private static boolean isValid(int[][] maze, int x, int y, int[][] sol) {
        int n = maze.length;
        int m = maze[0].length;

        return x>=0 && x<n && y>=0 && y<m && maze[x][y] == 1 && sol[x][y] == 0;
    }

    private static boolean solveMaze(int[][] maze, int x, int y, int[][] sol) {
        int n = maze.length;
        int m = maze[0].length;

        if(x == n-1 && y==m-1) {
            sol[x][y] = 1;
            return true;
        }
        int[] row = {1,0};
        int[] col = {0,1};

        if(isValid(maze, x, y, sol)) {
            sol[x][y] = 1;
            for(int k=0;k<row.length;k++) {
                if(solveMaze(maze, x+row[k], y+col[k], sol)) {
                    return true;
                }
            }
            sol[x][y] = 0;
        }
        return false;
    }

    private static void printSolution(int[][] sol) {
        int n = sol.length;
        int m = sol[0].length;

        for(int[] arr : sol) {
            for(int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static void solve(int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;

        int[][] sol = new int[n][m];
        if(solveMaze(maze, 0, 0, sol)) {
            printSolution(sol);
        } else {
            System.out.println("Solution doesn't exist");
        }
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };
        solve(maze);
    }
}
