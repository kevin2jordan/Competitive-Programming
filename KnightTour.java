public class KnightTour {

    private static void printSolution(int[][] sol) {
        int n = sol.length;
        for (int[] ints : sol) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] sol, int x, int y) {
        int n = sol.length;

        return x>=0 && x<n && y>=0 && y<n && sol[x][y] == -1;
    }

    private static boolean solveKnightTour(int[][] sol, int x, int y, int curr) {
        int n = sol.length;
        if(curr == n*n){
            return true;
        }

        int[] row = {2,1,-1,-2,-2,-1,1,2};
        int[] col = {1,2,2,1,-1,-2,-2,-1};

        if(isValid(sol, x, y)){
            sol[x][y] = curr;
            for(int k=0;k<row.length;k++){
                if(solveKnightTour(sol, x+row[k], y+col[k], curr+1)){
                    return true;
                }
            }
            sol[x][y] = -1;
        }
       return false;
    }

    private static void solveKT(int n) {
        int[][] sol = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                   sol[i][j] = -1;
            }
        }

        if(!solveKnightTour(sol,0,0,0)) {
            System.out.println("Not possible");
        } else {
            printSolution(sol);
        }
    }

    public static void main(String[] args) {

        solveKT(8);
    }
}
