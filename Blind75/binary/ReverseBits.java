package Blind75.binary;

public class ReverseBits {

    private static int getReverseBitsNumber(int n) {
        int reverseNum = 0;
        for(int i=0;i<32;i++) {
            if((n&(1<<i)) != 0) {
                System.out.println("setting bits " + (n-i-1));
                reverseNum |= 1<<(32-i-1);
            }
        }
        return reverseNum;
    }

    public static void main(String args[]) {
        int n = 5;
        System.out.println(getReverseBitsNumber(n));
    }
}
