package Blind75.array;

import java.util.Arrays;

public class ProductArrayExceptItself {

    /*
        Time: O(n)
        Space: O(n)
        space is O(n) + O(n)

        can we reduced the space further ?? yes
     */
    private static int[] getProductArray(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];
        left[0] = 1;
        right[n-1] = 1;

        for(int i=1;i<n;i++) {
            left[i] = left[i-1]*arr[i-1];
        }

        for(int i=n-2;i>=0;i--) {
            right[i] = right[i+1]*arr[i+1];
        }

        for(int i=0;i<n;i++) {
            arr[i] = left[i]*right[i];
        }

        return arr;
    }

    /*
       Time: O(n)
       Space: O(n)
    */
    private static int[] productArray(int[] arr) {
        int n = arr.length;
        int[] product = new int[n];
        Arrays.fill(product, 1);
        int temp = 1;
        for(int i=0;i<n;i++) {
            product[i] = temp;
            temp *= arr[i];
        }
        temp = 1;
        for(int i=n-1;i>=0;i--) {
            product[i] *= temp;
            temp *= arr[i];
        }

        return product;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};

        int[] result = productArray(arr);

        for(int ele:  result) {
            System.out.print(ele + " ");
        }
    }
}
