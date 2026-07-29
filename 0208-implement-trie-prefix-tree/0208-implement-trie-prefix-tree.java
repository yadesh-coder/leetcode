class Trie {
    class TrieNode {
        TrieNode[] child;
        boolean isend;
        TrieNode() {
            child = new TrieNode[26];
            isend = false;
        }
    }
    public TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null)
                curr.child[idx] = new TrieNode();
            curr = curr.child[idx];
        }
        curr.isend = true;
    }
    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.child[idx] == null)
                return false;
            curr = curr.child[idx];
        }
        return curr.isend;
    }
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.child[idx] == null)
                return false;
            curr = curr.child[idx];
        }
        return true;
    }
}