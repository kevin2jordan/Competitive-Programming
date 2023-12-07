package Blind75.DP;

public class WaysToExchangeCoin {

    static int[][] dp;
    private static int getWaysToExchangeCoinRecr(int[] coins, int n, int target) {
        if(target == 0) {
            return 1;
        }
        if(target < 0) {
            return 0;
        }

        if(n <=0) {
            return 0;
        }

        if(dp[n][target] != 0) {
            System.out.println("Coming inside memoized");
            return dp[n][target];
        }
        return dp[n][target] = getWaysToExchangeCoinRecr(coins, n-1, target) +
                getWaysToExchangeCoinRecr(coins, n, target-coins[n-1]);
    }

    private static int getWaysToExchangeCoin(int[] coins, int target) {
        int[] ways = new int[target+1];
        ways[0] = 1;
        int n = coins.length;
        for(int i=0;i<n;i++) {
            for(int j=coins[i];j<=target;j++) {
                ways[j] += ways[j-coins[i]];
            }
        }
        return ways[target];
    }

    public static void main(String[] args) {
        int[] coins = {1,2,3};
        int target = 5;

        dp = new int[coins.length+1][target+1];
        System.out.println(getWaysToExchangeCoinRecr(coins, coins.length, target));
        System.out.println(getWaysToExchangeCoin(coins, target));
    }
}
