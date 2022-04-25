package Blind75.DP;

public class LongestCommonSubsequence {

    private static int getlcsRecr(String str1, String str2, int n, int m) {
        if(n==0 || m==0) {
            return 0;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            return 1 + getlcsRecr(str1, str2, n-1, m-1);
        }

        return Math.max(getlcsRecr(str1, str2, n-1, m), getlcsRecr(str1, str2, n, m-1));
    }

    private static int getlcs(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] lcs = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = 1 + lcs[i-1][j-1];
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        return lcs[n][m];
    }

    public static void main(String[] args) {
        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";
        int n = str1.length();
        int m = str2.length();
        System.out.println(getlcsRecr(str1, str2, n, m));
        System.out.println(getlcs(str1, str2));
    }
}
