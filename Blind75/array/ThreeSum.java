package Blind75.array;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    /*
        All the three elements are distinct and there sum is zero.
        The array is unsorted and can have duplicates.
     */
    private static List<List<Integer>> getTriplets(int[] arr) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n-2;i++) {
            if(i == 0 || arr[i] != arr[i - 1]) {
                int l = i + 1;
                int r = n - 1;
                while (l < r) {
                    if (arr[i] + arr[l] + arr[r] < 0) {
                        l++;
                    } else if (arr[i] + arr[l] + arr[r] > 0) {
                        r--;
                    } else {
                        result.add(Arrays.asList(arr[i], arr[l], arr[r]));
                        while (l < r && arr[r] == arr[r - 1]) r--;
                        while (l < r && arr[l] == arr[l + 1]) l++;
                        l++;
                        r--;
                    }
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        List<List<Integer>> triplets = getTriplets(arr);

        for(List<Integer> list : triplets) {
            for(int ele : list) {
                System.out.print(ele +  " ");
            }
            System.out.println();
        }
    }
}
