package dp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MinimumDeletionPalindrome {
    private static int getMinimumDeletion(String str, int l, int r) {
        if(l > r) {
            return 0;
        }
        if(l == r) {
            return 1;
        }

        if(str.charAt(l) == str.charAt(r)) {
            return 2 + getMinimumDeletion(str, l+1, r-1);
        }

        return Math.max(getMinimumDeletion(str, l+1, r), getMinimumDeletion(str, l, r-1));
    }

    public static void main(String[] args) {
        List<String> inputs = new LinkedList<>(Arrays.asList("aebcbda", "cbbd", "bbbab", "geeksforgeeks"));
        for(String str : inputs) {
            int n = str.length();
            System.out.println(n-getMinimumDeletion(str, 0, n-1));
        }
    }
}
