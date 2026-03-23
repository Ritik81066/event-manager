package datastructures;

import java.util.HashMap;

public class EventTrie {

    private static class TrieNode {

        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEndOfWord = false;
    }

    private TrieNode root = new TrieNode();

    public void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }

        node.isEndOfWord = true;
    }

    public boolean search(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {

            if (!node.children.containsKey(c)) {
                return false;
            }

            node = node.children.get(c);
        }

        return node.isEndOfWord;
    }
}