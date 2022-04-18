package dp;

import java.util.Arrays;

public class minimumDenomination {
    private static int getMinimumCoins(int[] coins, int amount) {
        int[] minimumCoins = new int[amount+1];
        int n = coins.length;

        Arrays.fill(minimumCoins, Integer.MAX_VALUE);
        minimumCoins[0] = 0;
        for(int i=0;i<n;i++) {
            for(int j=coins[i];j<=amount;j++) {
                int subRes = minimumCoins[j-coins[i]];
                if(subRes != Integer.MAX_VALUE && 1+subRes < minimumCoins[j]) {
                    minimumCoins[j] = 1+subRes;
                }
            }
        }
        return minimumCoins[amount] == Integer.MAX_VALUE ? -1 : minimumCoins[amount];
    }
    public static void main(String args[]) {
        int coins[] = {1,2,5};
        int amount = 5;

        System.out.println(getMinimumCoins(coins, amount));
    }
}
