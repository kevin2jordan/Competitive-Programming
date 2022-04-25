package Blind75.DP;

import java.util.Arrays;

public class CoinChangeMinimum {

    private static int getMinimumCoinsRecr(int[] coins, int target) {
        if(target == 0) {
            return 0;
        }
        int result = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++) {
            if(coins[i] <= target) {
                int subRes = getMinimumCoinsRecr(coins, target-coins[i]);
                if(subRes != Integer.MAX_VALUE && 1+subRes < result) {
                    result = 1 + subRes;
                }
            }
        }
        return result;
    }

    private static int getMinimumCoins(int[] coins, int target) {
        int[] dp = new int[target+1];
        int n = coins.length;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<n;i++) {
            for(int j=coins[i];j<=target;j++) {
                int subRes = dp[j-coins[i]];
                if(subRes != Integer.MAX_VALUE && 1+subRes < dp[j]) {
                    dp[j] = 1 + subRes;
                }
            }
        }
        return dp[target];
    }

    private static int getMinimumCoinsMemo(int[] coins, int target, int dp[]) {
        if(target == 0) {
            return 0;
        }
        if(dp[target] != 0) {
            return dp[target];
        }
        int result = Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++) {
            if(coins[i] <= target) {
                int subRes = getMinimumCoinsMemo(coins, target-coins[i], dp);
                if(1+subRes < result) {
                    result = 1+subRes;
                }
            }
        }
        return dp[target] = result;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5,6,11};
        int target = 13;
        System.out.println(getMinimumCoinsRecr(coins, target));
        System.out.println(getMinimumCoins(coins, target));

        int[] dp = new int[target+1];
        System.out.println(getMinimumCoinsMemo(coins, target, dp));
    }
}
