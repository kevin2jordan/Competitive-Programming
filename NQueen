import java.util.Scanner;

public class NQueen {

    private static void printSolution(int[][] board) {
        int n = board.length;
        for (int[] ints : board) {
            for (int j = 0; j < n; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean isValid(int[][] board, int row, int col) {
        int n = board.length;
        int i,j;

        /**
         *  (0,0) (0,1) (0,2)
         *  (1,0) (1,1) (1,2)
         *  (2,0) (2,1) (2,2)
         */

        // Same row
        for(i=0;i<n;i++){
            if(board[row][i] == 1){
                return false;
            }
        }

        // left upper diagonal
        for(i=row,j=col ; i>=0 && j>=0 ; i--,j--){
            if(board[i][j] == 1){
                return false;
            }
        }

        // left lower diagonal
        for(i=row,j=col; i<n && j>=0 ; i++,j--){
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
    private static boolean solveNQueen(int[][] board, int col, int n) {

        if(col == n){
            return true;
        }

        for(int i=0;i<n;i++){
            if(isValid(board,i,col)) {
                board[i][col] = 1;
                if(solveNQueen(board, col+1,n)){
                    return true;
                }
                board[i][col] = 0;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int[][] board = new int[n][n];
        if(!solveNQueen(board,0,n)) {
            System.out.println("Solution doesn't exist");
        } else {
            printSolution(board);
        }

    }
}
