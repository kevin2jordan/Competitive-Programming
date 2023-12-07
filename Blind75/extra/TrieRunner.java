package Blind75.extra;


public class TrieRunner {
    public static void main(String[] args) {
        Trie root = new Trie();
        root.add("cat");
        root.add("cap");
        root.add("cow");
        root.add("abc");
        root.add("abd");


        System.out.print(root.search("cap"));
    }
}
