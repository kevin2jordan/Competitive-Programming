import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int board[][] = new int[n][n];

        if(solveNQueen(board, 0,n)) {
            printSolution(board);
        } else {
            System.out.print("Solution doesn't exist");
        }
    }

    private static void printSolution(int[][] board) {
        for(int arr[] : board) {
            for(int val : arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static boolean solveNQueen(int[][] board, int col, int n) {
        if(col == n) {
            return true;
        }

        for(int i=0;i<n;i++) {
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

    private static boolean isValid(int[][] board, int row, int col) {
        int n = board.length;

        for(int i=0;i<n;i++) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        for(int i=row,j=col;i>=0 && j>=0; i--,j--) {
            if(board[i][j] == 1) {
                return false;
            }
        }

        for(int i=row,j=col;i<n && j>=0; i++,j--){
            if(board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
