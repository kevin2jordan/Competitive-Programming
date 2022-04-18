package dp;

public class LCSubsequence {

    private static int getLCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    private static int LCSRecr(String str1, int n, String str2, int m) {
        if(n == 0 || m == 0) {
            return 0;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return 1 + LCSRecr(str1, n-1, str2, m-1);
        }
        return Math.max(LCSRecr(str1, n-1, str2, m), LCSRecr(str1, n, str2, m-1));
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        System.out.println(getLCS(str1, str2));
        System.out.println(LCSRecr(str1, str1.length(), str2, str2.length()));
    }
}
