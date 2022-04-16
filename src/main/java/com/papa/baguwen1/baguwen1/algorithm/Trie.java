package com.papa.baguwen1.baguwen1.algorithm;

//208. 实现 Trie (前缀树)
public class Trie {
    Trie[] children;
    private boolean isFinal;
    public Trie() {
        children = new Trie[26];
    }

    public void insert(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null){
                temp.children[index] = new Trie();
            }
            temp = temp.children[index];
        }
        temp.isFinal = true;
    }

    public boolean search(String word) {
        Trie temp = this;
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null){
                return false;
            }
            temp = temp.children[index];
        }
        return temp.isFinal;
    }

    public boolean startsWith(String prefix) {
        Trie temp = this;
        for (int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (temp.children[index] == null){
                return false;
            }
            temp = temp.children[index];
        }
        return true;
    }

    public static void main(String[] args) {
         Trie obj = new Trie();
         obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.search("app"));
        System.out.println(obj.startsWith("app"));
       obj.insert("app");
        System.out.println(obj.search("app"));
    }
}
