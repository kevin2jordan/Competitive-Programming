package Blind75.DP;

import java.util.Arrays;
import java.util.List;

public class DecodeWays {
    private static int getways(String str) {
        if(null == str || str.length() == 0) {
            return 0;
        }
        int n = str.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i=2;i<=n;i++) {
            if(str.charAt(i-1) >'0') {
                dp[i] = dp[i-1];
            }
            if(str.charAt(i-2) == '1' || str.charAt(i-2) == '2' && str.charAt(i-1) <'7') {
                dp[i] += dp[i-2];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        List<String> inputs = Arrays.asList("1","12","226",null,"");
        for(String str : inputs) {
            System.out.println(getways(str));
        }
    }
}
