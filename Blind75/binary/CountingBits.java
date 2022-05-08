package Blind75.binary;

public class CountingBits {
    private static int[] countingBits(int n) {
        int dp[] = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++) {
            dp[i] = dp[i/2] + i%2;
        }

        return dp;
    }
    public static void main(String args[]) {
        int n = 5;

        int[] result = countingBits(n);
        for(int val : result) {
            System.out.print(val + " ");
        }
    }
}
