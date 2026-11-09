class TrieNode {
    TrieNode [] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i=0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                curr.children[word.charAt(i) - 'a'] = new TrieNode();
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        curr.endOfWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i=0; i < word.length(); i++) {
            if (curr.children[word.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[word.charAt(i) - 'a'];
        }
        if (curr.endOfWord) return true;
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i=0; i < prefix.length(); i++) {
            if (curr.children[prefix.charAt(i) - 'a'] == null) {
                return false;
            }
            curr = curr.children[prefix.charAt(i) - 'a'];
        }
        return true;
    }
}
