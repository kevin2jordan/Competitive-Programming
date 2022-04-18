import java.util.Arrays;
import java.util.Scanner;

public class KnightTour {

    private static void printSolution(int[][] sol) {
        for(int []arr : sol) {
            for(int ele : arr) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] sol, int x, int y) {
        int n = sol.length;
        int m = sol[0].length;

        return x>=0 && x<n && y>=0 && y<m && sol[x][y] == -1;
    }

    private static boolean solveKnightTour(int[][] sol, int x, int y, int movei) {
        int n = sol.length;
        if(movei == n*n){
            return true;
        }
        int []row = {2,1,-1,-2,-2,-1,1,2};
        int []col = {1,2,2,1,-1,-2,-2,-1};

        if(isValid(sol, x, y)) {
            sol[x][y] = movei;

            for(int k=0;k<row.length;k++) {
                if(solveKnightTour(sol, x+row[k], y+col[k], movei+1)) {
                    return true;
                }
            }
            sol[x][y] = -1;
        }
        return false;
    }

    private static void solveKnightTour(int n) {
        int[][] sol = new int[n][n];
        for(int[] arr : sol) {
            Arrays.fill(arr, -1);
        }

        if(solveKnightTour(sol,0,0,0)) {
            printSolution(sol);
        } else {
            System.out.println("Solution doesn't exist ");
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        solveKnightTour(n);
    }
}
