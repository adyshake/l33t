//https://leetcode.com/problems/implement-trie-prefix-tree/
class Trie {
    class TrieNode {
        final int R = 26;
        boolean isEnd;
        TrieNode[] links;
        
        public TrieNode() {
            links = new TrieNode[R];    
        }
        
        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }
        
        public TrieNode get(char ch){
            return links[ch - 'a'];    
        }
        
        public void put(char ch, TrieNode node){
            links[ch - 'a'] = node;
        }
        
        public void setEnd() {
            isEnd = true;
        }
        
        public boolean isEnd(){
            return isEnd;
        }
        
    }

    TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();    
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        
        for (int i = 0; i < word.length(); i++){
            char cur = word.charAt(i);
            if (!node.containsKey(cur)){
                //System.out.println("Inserting " + cur);
                TrieNode next = new TrieNode();
                node.put(cur, next);
            }
            node = node.get(cur);
        }
        node.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = startsWithHelper(word);
        return node != null && node.isEnd();
    }
    
    public TrieNode startsWithHelper(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            char cur = prefix.charAt(i);
            if (node.containsKey(cur)) {
                node = node.get(cur);
            } else {
                return null;
            }
        }
        return node;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        return startsWithHelper(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */