package dp;

public class MSIS {

    private static int getMaximumSumIS(int[] arr) {
        int n = arr.length;
        int[] msis = new int[n];
        int result = 0;
        for(int i=0;i<n;i++) {
            msis[i] = arr[i];
        }

        for(int i=1;i<n;i++) {
            for(int j=0;j<i;j++) {
                if(arr[i] > arr[j]) {
                    msis[i] = Math.max(msis[i], arr[i]+msis[j]);
                    result = Math.max(msis[i], result);
                }
            }
        }
        return  result;
    }

    public static void main(String args[]) {
        int[] arr = {1, 101, 2, 3, 100, 4, 5};
        System.out.println(getMaximumSumIS(arr));
    }
}
