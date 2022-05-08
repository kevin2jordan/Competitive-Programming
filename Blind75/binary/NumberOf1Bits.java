package Blind75.binary;

public class NumberOf1Bits {
    private static int getTotalSetBits(int n) {
        int setBits = 0;
        for(int i=31;i>=0;i--) {
            if((1&(n>>i)) > 0) {
                setBits++;
            }
        }
        return setBits;
    }

    public static void main(String args[]) {
        int n = 32;
        System.out.println("Total set bits are " + getTotalSetBits(n));
    }
}
