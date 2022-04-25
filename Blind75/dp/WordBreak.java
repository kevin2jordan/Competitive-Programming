package Blind75.DP;

import java.util.Arrays;
import java.util.List;

public class WordBreak {

    private static boolean wordBreak(String word, List<String> wordDict) {
        int n = word.length();
        boolean[] visited = new boolean[n+1];
        for(int i=0;i<=n;i++) {
            if(!visited[i] && wordDict.contains(word.substring(0,i))) {
                visited[i] = true;
            }
            if(visited[i]){
                if(i == n) {
                    return true;
                }
                for(int j=i;j<=n;j++) {
                    if(!visited[j] && wordDict.contains(word.substring(i,j))) {
                        visited[j] = true;
                    }
                    if(j == n && visited[j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean wordBreakRecr(String word, List<String> wordDict) {
        if(word.length() == 0) {
            return true;
        }

        for(int i=1;i<=word.length();i++) {
            if(wordDict.contains(word.substring(0,i)) && wordBreakRecr(word.substring(i), wordDict)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String word = "leetcode";
        List<String> wordDict = Arrays.asList("leet","code");

        System.out.println(wordBreakRecr(word, wordDict));
        System.out.println(wordBreak(word, wordDict));
    }
}
