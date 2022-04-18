package dp;

public class BinomailCoefficient {
    private static int getCoefficient(int x, int y) {
        int result = 1;
        for(int i=1;i<=y;i++) {
            result = result*(x-i+1);
            result = result/i;
        }

        return result;
    }
    public static void main(String[] args) {
        int n = 5, r =1;
        System.out.println(getCoefficient(n, r));
    }
}
