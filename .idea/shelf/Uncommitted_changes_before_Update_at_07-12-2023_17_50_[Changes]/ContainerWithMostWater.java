package dp.Blind75.array;

public class ContainerWithMostWater {
    private static int getMaxWater(int[] arr) {
        int maxWater = 0;
        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            maxWater = Math.max(maxWater, Math.min(arr[low], arr[high]) * (high-low));
            if(arr[low] < arr[high]) {
                low++;
            } else {
                high--;
            }
        }
        return maxWater;
    }

    public static void main(String args[]) {
       // int[] arr = {1,8,6,2,5,4,8,3,7};
        int[] arr = {1,1};
        System.out.println(getMaxWater(arr));
    }
}
