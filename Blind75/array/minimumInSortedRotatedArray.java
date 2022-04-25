package Blind75.array;

public class minimumInSortedRotatedArray {
    private static int getMinimumEle(int[] arr) {
        int low=0;
        int high = arr.length-1;

        while(low < high) {
            int mid = low + (high-low)/2;
            if(arr[mid] == arr[high]) {
                high--;
            } else if(arr[mid] > arr[high]) {
                low = mid+1;
            } else high = mid;
        }

        return arr[high];
    }

    private static int minEleRecr(int[] arr, int low, int high) {
        if(low > high) {
            return arr[0];
        }
        if(low == high) {
            return arr[low];
        }
        int mid = low + (high-low)/2;
        if(mid < high && arr[mid+1] < arr[mid]) {
            return arr[mid+1];
        }
        if(mid > low && arr[mid-1] > arr[mid]) {
            return arr[mid];
        }

        if(arr[high] > arr[mid]) {
            return minEleRecr(arr,low, mid-1);
        }
        return minEleRecr(arr,mid+1, high);
    }
    private static int minEle(int[] arr) {
        int low = 0;
        int high = arr.length-1;

        while(low <= high) {
            int mid = low+(high-low)/2;
            if(mid < high && arr[mid] > arr[mid+1]) {
                return arr[mid+1];
            }
            if(mid > low && arr[mid-1] > arr[mid]) {
                return arr[mid];
            }

            if(arr[mid] > arr[high]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return arr[low];
    }

    public static void main(String[] args) {
       // int[] arr = {3,4,5,6,11,2};
       // int[] arr = {1,2,3,4,5,6};
        int[] arr = {5,6,1,2,3,4};
      //  int[] arr = {2,2,2,2,2,2};
       // int[] arr = {3,3,4,4,5,6,1,1,2};
        System.out.println(getMinimumEle(arr));
        System.out.println(minEle(arr));
        System.out.println(minEleRecr(arr, 0, arr.length-1));
    }
}
