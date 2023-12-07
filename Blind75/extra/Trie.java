package Blind75.extra;

public class Trie {

    private static TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    public void add(String word) {
        TrieNode curr = root;
        for(char ch :word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                curr.children[ch-'a'] = new TrieNode();
            }
            curr = curr.children[ch-'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()) {
            if(curr.children[ch-'a'] == null) {
                return false;
            }
            curr = curr.children[ch-'a'];
        }
        return curr.isEnd;
    }
}
