package Blind75.DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CombinationSum2 {

    private static void getAllCombination(int[] arr, int target, int ind, List<Integer> temp,
                                          List<List<Integer>> result) {
        if(target == 0) {
            if(!result.contains(temp))
                result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<arr.length;i++) {
            if(arr[i] <= target) {
                temp.add(arr[i]);
                getAllCombination(arr, target-arr[i], i+1, temp, result);
                temp.remove(new Integer(arr[i]));
            }
        }
    }

    private static void getAllCombinationOptimized(int[] arr, int target, int ind, List<Integer> temp,
                                          List<List<Integer>> result) {
        if(target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<arr.length;i++) {
           if(i>ind && arr[i] == arr[i-1]) {
               continue;
           }
           if(arr[i] <= target) {
               temp.add(arr[i]);
               getAllCombinationOptimized(arr, target - arr[i], i + 1, temp, result);
               temp.remove(new Integer(arr[i]));
           }
        }
    }

    private static List<List<Integer>> getAllCombinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getAllCombination(arr, target, 0, temp, result);

        return result;
    }

    private static List<List<Integer>> getAllCombinationSumOptimized(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getAllCombinationOptimized(arr, target, 0, temp, result);

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        Arrays.sort(arr);

        List<List<Integer>> result = getAllCombinationSum(arr, target);

        for(List<Integer> list : result) {
            for(int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        List<List<Integer>> result1 = getAllCombinationSumOptimized(arr, target);
        System.out.println();
        System.out.println();
        for(List<Integer> list : result1) {
            for(int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
