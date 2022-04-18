import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    private static void solveTwoSum(int[] arr) {
        Set<Integer> hashSet = new HashSet<>();

        for(int ele : arr) {
            if(hashSet.contains(-ele)) {
                System.out.println(ele + " " + -ele);
            }
            hashSet.add(ele);
        }
    }

    private static void solveThreeSum(int[] arr) {

        int n = arr.length;
        for(int i=0;i<n-1;i++) {
            Set<Integer> hashSet = new HashSet<>();
            for(int j=i+1;j<n;j++) {
                int x = arr[i] + arr[j];
                if(hashSet.contains(-x)) {
                    System.out.println(arr[i] + " " + arr[j] + " " + -(arr[i]+arr[j]));
                }
                hashSet.add(arr[j]);
            }
        }

    }
    public static void main(String[] args) {
        int[] arr = {1,-2,-3,4,5,1,2};

        solveThreeSum(arr);
    }
}
