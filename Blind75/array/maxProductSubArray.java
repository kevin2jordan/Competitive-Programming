package Blind75.array;

public class maxProductSubArray {

    /*
        Time: O(n)
        Space: O(n)
     */
    private static int calculateMaxProdSubArray(int[] arr) {
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        int maxPositive = arr[0];
        int minNegative = arr[0];
        int maxProduct = arr[0];
        for(int i=1;i<n;i++) {
            if(arr[i] < 0) {
                int temp = maxPositive;
                maxPositive = minNegative;
                minNegative = temp;
            }
            maxPositive = Math.max(arr[i], arr[i]*maxPositive);
            minNegative = Math.min(arr[i], arr[i]*minNegative);
            maxProduct = Math.max(maxProduct, maxPositive);
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] arr = {6,-3,-10,0,2,100};
        System.out.println(calculateMaxProdSubArray(arr));
    }
}
