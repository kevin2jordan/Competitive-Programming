package dp.Blind75.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {
    /*
        Time: O(n)
        Space: O(n)
     */
    private static boolean isDuplicatePresent(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();
        for(int ele : arr) {
            hashSet.add(ele);
        }

        return arr.length != hashSet.size();
    }

    /*
       With two iteration
       Time: O(n)
       Space: O(n)
    */
    private static boolean containsDuplicate(int[] arr) {
        Map<Integer, Integer> hashMap = new HashMap<>();
        for(int ele : arr) {
            hashMap.put(ele, hashMap.getOrDefault(ele,0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if(entry.getValue() > 1) {
                return true;
            }
        }

        return false;
    }

    /*
       Time: O(nlon)
       Space: O(1)
    */
    private static boolean duplicateCheckUsingSorting(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;

        for(int i=0;i<n;i++) {
            if(i<n-1 && arr[i] == arr[i+1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,1,1,2,3};
        System.out.println(isDuplicatePresent(arr));
        System.out.println(containsDuplicate(arr));
        System.out.println(duplicateCheckUsingSorting(arr));
    }
}
