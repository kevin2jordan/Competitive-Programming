package Blind75.DP;

public class OptimalBST {

    private static int getOptimalBST(int[] keys, int[] freq, int l, int r) {
        if(l > r) {
            return 0;
        }
        if(l == r) {
            return freq[l];
        }
        int freqsum = getSum(freq, l, r);
        int result = Integer.MAX_VALUE;
        for(int k=l;k<=r;k++) {
            int sum = getOptimalBST(keys, freq, l,k-1) + getOptimalBST(keys, freq, k+1, r);
            if(sum < result) {
                result = sum;
            }
        }
        return  freqsum + result;
    }

    private static int getSum(int[] freq, int start, int end) {
        int sum = 0;
        for(int i=start;i<=end;i++) {
            sum += freq[i];
        }

        return sum;
    }
    public static void main(String[] args) {
        int[] keys = {10, 12, 20};
        int[] freq = {34, 8, 50};
        int n = freq.length;
        System.out.println(getOptimalBST(keys, freq, 0, n-1));
    }
}
