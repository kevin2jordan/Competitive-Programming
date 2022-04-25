package Blind75.array;

public class StockBuySell1 {

    /*
        Time: O(n)
        Space: O(1)
     */
    private static int getMaximumProfits(int[] arr) {
        int minEle = arr[0];
        int maxVal = 0;

        for(int i=1;i<arr.length;i++) {
            maxVal = Math.max(maxVal, arr[i]-minEle);
            minEle = Math.min(minEle, arr[i]);
        }

        return maxVal;
    }
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(getMaximumProfits(arr));
    }
}
