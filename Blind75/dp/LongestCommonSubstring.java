package Blind75.DP;

public class LongestCommonSubstring {

    /*
        Time: O(2^n)
        Space: O(n)
     */
    private static int getLCSRecr(String str1, String str2, int n, int m, int cnt) {
        if(n == 0 || m == 0){
            return cnt;
        }
        if(str1.charAt(n-1) == str2.charAt(m-1)) {
            cnt = getLCSRecr(str1, str2, n-1, m-1, cnt+1);
        }

        cnt =  Math.max(cnt,
                Math.max(getLCSRecr(str1, str2, n-1, m, 0), getLCSRecr(str1, str2, n, m-1, 0)));

        return cnt;
    }

    /*
        Time: O(n2)
        Space: O(n2)
     */
    private static int getLCS(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int[][] lcs = new int[n+1][m+1];
        int maxLen = 1;

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if(str1.charAt(i-1) == str2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                    maxLen = Math.max(maxLen, lcs[i][j]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String str1 = "zxabcdezy";
        String str2 = "yzabcdezx";
        int n = str1.length();
        int m = str2.length();
        System.out.println(getLCSRecr(str1, str2, n, m, 0));
        System.out.println(getLCS(str1, str2));
    }
}
