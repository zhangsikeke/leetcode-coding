package 练习202107月份;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 字典树
 *
 * @author: keke
 * @date: 2021/7/12 22:38
 */
public class A19_208_实现前缀树 {
    public static void main(String[] args) {
        A19_208_实现前缀树 trie = new A19_208_实现前缀树();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app");      // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }

    static class Node {
        int val;
        boolean isEnd = false;
        Node[] children = new Node[26];

        public Node(int val) {
            this.val = val;
        }
    }

    Node root;
    int deep = 0;

    /**
     * Initialize your data structure here.
     */
    public A19_208_实现前缀树() {
        root = new Node(0);
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node tmp = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (tmp.children[ch] == null) {
                tmp.children[ch] = new Node(ch);
            }
            tmp = tmp.children[ch];
        }
        tmp.isEnd = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node tmp = root;
        for (int i = 0; i < word.length(); i++) {
            int ch = word.charAt(i) - 'a';
            if (tmp.children[ch] == null) {
                return false;
            }
            tmp = tmp.children[ch];
        }
        return tmp != null && tmp.isEnd;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Node tmp = root;
        for (int i = 0; i < prefix.length(); i++) {
            int ch = prefix.charAt(i) - 'a';
            if (tmp.children[ch] == null) {
                return false;
            }
            tmp = tmp.children[ch];
        }
        return true;
    }

}
