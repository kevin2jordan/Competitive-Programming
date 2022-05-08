package Blind75.DP;

public class UniquePaths {
    private static int totalPaths(int n, int m) {
        if(n == 1 || m == 1) {
            return 1;
        }

        return totalPaths(n-1, m) + totalPaths(n,m-1);
    }

    private static int totalPathsDP(int n, int m) {
        int dp[][] = new int[n+1][m+1];
        for(int i=0;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(i==0 || j==0) {
                    dp[i][j] = 1;
                } else  {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String args[]) {
        int n = 3, m = 7;
        System.out.println(totalPaths(n,m));
        System.out.println(totalPathsDP(n,m));
    }
}
