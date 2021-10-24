public class RatInAMaze {

    private static void printSolution(int[][] sol) {
        int n = sol.length;
        for (int[] ints : sol) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean  isValid(int[][] maze, int x, int y, int[][] sol) {
        int n = maze.length;

        return x>=0 && x<n && y>=0 && y<n && maze[x][y]==1 && sol[x][y] == 0;
    }

    private static boolean solveMazeUtil(int[][] maze, int[][] sol, int x, int y) {
        int n = maze.length;
        if(x==n-1 && y==n-1){
            sol[x][y] = 1;
            return true;
        }
        int[] row = {1,0};
        int[] col = {0,1};
        if(isValid(maze,x,y,sol)) {
            sol[x][y] = 1;
            for(int i=0;i<row.length;i++) {
                if(solveMazeUtil(maze, sol, x+row[i],y+col[i])){
                    return true;
                }
            }
            sol[x][y] = 0;
        }
        return false;
    }

    private static void solveRatMazePuzzle(int[][] maze) {
        int n = maze.length;
        int[][] sol = new int[n][n];

        if(!solveMazeUtil(maze, sol, 0, 0)){
            System.out.print("Solution doesn't exist");
        } else {
            printSolution(sol);
        }
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 0, 0 },
                { 1, 1, 0, 1 },
                { 0, 1, 0, 0 },
                { 1, 1, 1, 1 } };

        solveRatMazePuzzle(maze);
    }
}
