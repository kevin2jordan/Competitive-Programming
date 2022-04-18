package dp;

public class LCSubstring {
    private static int getLCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] dp = new int[n+1][m+1];
        int lcs = 0;
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = 1+dp[i-1][j-1];
                    lcs = Math.max(lcs, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return lcs;
    }

    public static void main(String args[]) {
        String str1 = "abcdxyz";
        String str2 = "xyzabcd";

        System.out.println(getLCS(str1, str2));
    }
}
