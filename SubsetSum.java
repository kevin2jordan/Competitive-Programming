package dp;

public class SubsetSum {
    static boolean dp[][];
    private static boolean checkSubsetSum(int[] arr, int n, int sum) {
        if(sum == 0) {
            return true;
        }
        if(n == 0) {
            return false;
        }
        if(dp[n - 1][sum]) {
            return dp[n-1][sum];
        }
        if(arr[n-1] > sum) {
            return dp[n-1][sum] = checkSubsetSum(arr,n-1,sum);
        }

        return  dp[n-1][sum] = checkSubsetSum(arr,n-1,sum-arr[n-1]) || checkSubsetSum(arr,n-1, sum);
    }
    public static void main(String args[]) {
        int set[] = {   3, 34, 4, 12, 5, 2 };
        int sum = 149;
        int n = set.length;
        dp = new boolean[n+1][sum+1];
        System.out.println(checkSubsetSum(set, n, sum));
    }
}
