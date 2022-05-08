package Blind75.DP;

public class JumpGame {
    private static boolean isPossible(int[] arr) {
        int n = arr.length;
        int ind = n-1;

        for(int i=n-1;i>=0;i--) {
            if(i+arr[i] >= ind) {
                ind = i;
            }
        }
        return ind == 0;
    }
    public static void main(String[] args) {
        int arr[] = {2,0,0,0,4};
        System.out.println(isPossible(arr));
    }
}
