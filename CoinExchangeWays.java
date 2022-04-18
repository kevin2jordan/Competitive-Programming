package dp;

public class CoinExchangeWays {

    public static void main(String args[]) {
        int coins[] = {1,2,3};
        int amount = 4;

        System.out.println(getWaysToExchangeCoins(coins, amount));
    }

    private static int getWaysToExchangeCoins(int[] coins, int amount) {
        int[] ways = new int[amount+1];
        int n = coins.length;
        ways[0] = 1;
        for(int i=0;i<n;i++) {
            for(int j=coins[i];j<=amount;j++) {
                ways[j] += ways[j-coins[i]];
            }
        }
        return ways[amount];
    }
}
