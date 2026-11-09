class TrieNode {
    TrieNode [] children = new TrieNode[26];
    boolean endOfWord = false;
}

class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
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
        return searchNode(word, root);
    }

    public boolean searchNode(String word, TrieNode node) {
        if (node == null) return false;
        if (word.equals("")) {
            return node.endOfWord;
        }

        boolean hasWord = false;
        if (word.charAt(0) == '.') {
            for (int i=0; i < 26; i++) {
                hasWord = hasWord || searchNode(word.substring(1), node.children[i]);
            }
            return hasWord;
        }

        return searchNode(word.substring(1), node.children[word.charAt(0) - 'a']);
    }
}
