package Blind75.DP;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static void getAllCombinationSum(int[] arr, int target, List<Integer> temp, List<List<Integer>> result,
                                             int ind) {
        if(target == 0) {
            if(!result.contains(temp)) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }

        for(int i=ind;i<arr.length;i++) {
            if(arr[i] <= target) {
                temp.add(arr[i]);
                getAllCombinationSum(arr, target-arr[i], temp, result, i);
                temp.remove(new Integer(arr[i]));
            }
        }
    }
    private static List<List<Integer>> getAllCombinationSum(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        getAllCombinationSum(arr, target, temp, result,0);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int target = 4;

        List<List<Integer>> result = getAllCombinationSum(arr, target);

        for(List<Integer> list : result) {
            for(int val : list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
