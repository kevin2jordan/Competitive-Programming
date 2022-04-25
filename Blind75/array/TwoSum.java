package Blind75.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TwoSum {

    /*
        Time : O(nlogn) due to sorting
        Space: O(1)
     */
    private static int[] getPairUsingSorting(int[] arr, int target) {
        Arrays.sort(arr);
        int low = 0;
        int high = arr.length-1;
        int[] result = new int[2];
        while(low <= high) {
           if(arr[low] + arr[high] == target) {
               result[0] = arr[low++];
               result[1] = arr[high--];
           } else if(arr[low] + arr[high] > target) {
               high--;
           } else {
               low++;
           }
        }
        return result;
    }

    /*
        Time: O(n)
        Space: O(1)
     */
    private static int[] getPairUsingHasing(int[] arr, int target) {
        Set<Integer> hashSet = new HashSet<>();
        int[] result = new int[2];
        for(int ele : arr) {
            if(hashSet.contains(target-ele)) {
                result[0] = ele;
                result[1] = target - ele;
            } else hashSet.add(ele);

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2,7,11,9,6,5};
        int target = 11;
        int[] result = getPairUsingHasing(arr, target);
        for(int ele : result) {
            System.out.print(ele + " ");
        }
    }
}
