package dp;

import java.util.Arrays;

public class LIS {
    private static int getLIS(int[] arr) {
        int n = arr.length;
        int lis[] = new int[n];
        int result = 1;
        Arrays.fill(lis, 1);

        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                    result = Math.max(lis[i], result);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        System.out.println(getLIS(arr));
    }
}
