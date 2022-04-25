package Blind75.DP;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    private static int getLIS(int[] arr) {
        int n = arr.length;
        int lis[] = new int[n];
        int maxLen = 1;
        Arrays.fill(lis, 1);
        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], 1+lis[j]);
                    maxLen = Math.max(maxLen, lis[i]);
                }
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {2,3,4,1,0};
        System.out.println(getLIS(arr));
    }
}
