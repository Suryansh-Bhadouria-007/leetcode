package assessment;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class Trie {
    private Node root;

    class Node {
        TreeSet<String> words;
        Node[] children;

        public Node() {
            this.words = new TreeSet<>();
            this.children = new Node[26];
        }
    }

    public Trie() {
        this.root = new Node();
    }

    public void addWord(String word) {
        char[] chars = word.toCharArray();
        Node node = root;
        for (char ch : chars) {
            if (null == node.children[ch - 'a']) {
                node.children[ch - 'a'] = new Node();
            }
            node.words.add(word);
            node = node.children[ch - 'a'];
        }
        node.words.add(word);
    }

    public List<String> searchByPrefix(String prefix) {
        char[] chars = prefix.toCharArray();
        Node node = root;
        for (char ch : chars) {
            if (null == node.children[ch - 'a'])
                return new ArrayList<>();
            node = node.children[ch - 'a'];
        }
        return new ArrayList<>(node.words);
    }
}
