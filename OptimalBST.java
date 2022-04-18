package dp;

public class OptimalBST {
    static int[][] dp;
    private static int getFrequencySum(int[] freq, int l, int r) {
        int sum = 0;
        for(int i=l;i<=r;i++) {
            sum += freq[i];
        }

        return sum;
    }

    private static int optimalSearchTree(int[] keys, int[] freq, int l,int r) {
      // System.out.println("l and r is " + l + "  " + r);
        if(l > r) {
            return 0;
        }
        if(l == r) {
            return freq[l];
        }
        if(dp[l][r] != 0) {

            return dp[l][r];
        }
        int minVal = Integer.MAX_VALUE;
        int fSum = getFrequencySum(freq, l, r);

        for(int k=l;k<=r;k++) {
            int sum = optimalSearchTree(keys, freq, l, k-1) + optimalSearchTree(keys, freq, k+1, r);
            dp[l][r] = sum;
          //  System.out.println("Setting l and r " + l + "  " + r);
            if(sum < minVal) {
                minVal = sum;
            }
        }

        return minVal + fSum;
    }
    public static void main(String args[]) {
        int keys[] = {10, 12, 20};
        int freq[] = {34, 8, 50};
        int n = keys.length;
        dp = new int[n+1][n+1];
        System.out.println("Cost of Optimal BST is " +
                optimalSearchTree(keys, freq, 0, n-1));
    }
}
