package Blind75.array;

public class maxSubarray {
    private static int calculateMaxSubArray(int[] arr) {
        /*
            Time: O(n)
            Space: O(1)
         */
        int n =arr.length;
        if(n == 0) {
            return 0;
        }
        int maxSum = arr[0];
        int tempSum = arr[0];

        for(int i=1;i<n;i++) {
            tempSum = Math.max(arr[i], tempSum+arr[i]);
            maxSum = Math.max(maxSum, tempSum);
        }

        return maxSum;
    }

    private static int[] getMaxSubArray(int[] arr) {
       /*
            Time: O(n)
            Space: O(n)
         */
        if(arr.length == 0) {
            return new int[0];
        }
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        int start=0, end=0, s=0, n=arr.length;

        for(int i=1;i<n;i++) {
            maxEndingHere += arr[i];
            if(maxSoFar < maxEndingHere) {
                maxSoFar = maxEndingHere;
                start = s;
                end = i;
            }

            if(maxEndingHere < 0) {
                maxEndingHere = 0;
                s = i+1;
            }
        }

        int[] result = new int[end-start+1];
        for(int i=start;i<=end;i++) {
            result[i-start] = arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
         int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
       // int[] arr = {1};
       // int[] arr = {5,4,-1,7,8};
       // int[] arr = {-5,-4,-3,-2,-1};
      //  int[] arr = {};
      //  int[] arr = {-1,-2,-3,-4,-5};
        System.out.println(calculateMaxSubArray(arr));
        int[] result = getMaxSubArray(arr);
        for(int ele : result) {
            System.out.print(ele + " ");
        }

    }
}
