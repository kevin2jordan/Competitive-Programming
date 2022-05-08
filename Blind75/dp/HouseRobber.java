package Blind75.DP;

public class HouseRobber {

    private static int getMaxCollectedAmount(int[] arr, int start, int end) {
        int n = arr.length;
        if(n == 0) {
            return 0;
        }
        int incl = arr[0];
        int excl = 0;
        for(int i=1;i<n;i++) {
            int temp = Math.max(incl ,excl);
            incl = Math.max(arr[i], excl+arr[i]);
            excl = temp;
        }

        return Math.max(incl, excl);
    }


    private static int houseRobber2(int[] arr) {
        int n = arr.length;

        return Math.max(getMaxCollectedAmount(arr, 0,n-1), getMaxCollectedAmount(arr,1,n));
    }
    public static void main(String args[]) {
        int[] arr = {2,7,9,3,1};
        int n = arr.length;

        System.out.println(houseRobber2(arr));

        System.out.println(getMaxCollectedAmount(arr, 0, n));
    }
}
