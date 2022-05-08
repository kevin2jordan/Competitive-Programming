package Blind75.binary;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MissingNumber {

    /*
        Time : O(n)
        Space: O(1)
     */
    private static int getMissingNumber1(int arr[]) {
        int n = arr.length;
        int missingEle = 0;

        for(int i=1;i<=n;i++) {
            missingEle ^= arr[i-1];
            missingEle ^= i;
        }

        return missingEle;
    }

    /*
        Time : O(nlogn)
        Space: O(1)
     */
    private static int getMissingNumber2(int arr[]) {
        Arrays.sort(arr);
        int n = arr.length;

        for(int i=0;i<n;i++){
            if(i != arr[i]) {
                return i;
            }
        }
        return n;
    }

    /*
        Time : O(n)
        Space: O(1)
        Changing the current array
     */
    private static int getMissingNumber3(int arr[]) {
        int n = arr.length;
        int missinEle = n;
        for(int i=0;i<n;i++) {
            int val = Math.abs(arr[i]);
            if(val > n-1) {
                continue;
            }
            arr[val] = -arr[val];
        }

        for(int i=0;i<n;i++) {
            if(arr[i] > 0) {
                missinEle = i;
               break;
            }
        }
        // rollback to previous state of the array
        for(int i=0;i<n;i++) {
             arr[i] = Math.abs(arr[i]);
        }

        return missinEle;
    }

    /*
        Time : O(n)
        Space: O(n)
     */
    private static int getMissingNumber4(int arr[]) {
        Set<Integer> hashSet = new HashSet<>();
        for(int val : arr) {
            hashSet.add(val);
        }

        for(int i=0;i<=arr.length;i++) {
            if(!hashSet.contains(i)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3,2,1,4,0};

        System.out.println(getMissingNumber1(arr));
        System.out.println(getMissingNumber2(arr));
        System.out.println(getMissingNumber3(arr));
        System.out.println(getMissingNumber4(arr));

    }
}
