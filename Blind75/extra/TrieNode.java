package Blind75.extra;

public class TrieNode {
    TrieNode[] children;
    boolean isEnd;
    TrieNode() {
        children =  new TrieNode[26];
        isEnd =  false;
    }
}
