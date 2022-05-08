package Blind75.binary;

public class SumOfTwoIntegers {
    private static int sum(int a, int b) {
        while(b != 0) {
            int carry = a&b;
            a = a^b;
            b = carry<<1;
        }
        return a;
    }

    public static void main(String args[]) {
        int a = 5;
        int b = 7;

        System.out.println(sum(a,b));
    }
}
