package dp;

import java.util.Arrays;
import java.util.List;

public class WordBreak {
    private static boolean isWordBreakPossible(String word, List<String> wordDict) {
        int n = word.length();
        if(n == 0) {
            return true;
        }
        System.out.println("Word is " + word);
        for(int i=1;i<=n;i++) {
            if(wordDict.contains(word.substring(0,i)) && isWordBreakPossible(word.substring(i), wordDict)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isPossible(String word, List<String> wordDict) {
        int n = word.length();
        boolean[] substringExist = new boolean[n+1];

        for(int i=0;i<=n;i++) {
            if(!substringExist[i] && wordDict.contains(word.substring(0,i))) {
                substringExist[i] = true;
            }
            if(substringExist[i]) {
                if(i == n) {
                    return true;
                }
                for(int j=i;j<=n;j++) {
                    if(!substringExist[j] && wordDict.contains(word.substring(i,j))){
                        substringExist[j] = true;
                    }
                    if(j==n && substringExist[j]) {
                        return true;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String word = "ilikesamsung";
        List<String> wordDict = Arrays.asList("i", "like", "sam", "samsung", "mobile", "ice",
                "cream", "icecream", "man", "go", "mango");
        System.out.println(isPossible(word, wordDict));
    }
}
