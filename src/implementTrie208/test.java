package implementTrie208;

public class test {
	public static void main(String[] args) {
		
	}
}



class Trie {

    /** Initialize your data structure here. */
    public Trie() {
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        char[] a = word.toCharArray();
        for(char c: a) {
        	if(node.next[c-'a'] == null) {
        		node.next[c-'a'] = new Trie();
        	}
        	node = node.next[c-'a'];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this;
        char[] a = word.toCharArray();
        for(char c: a) {
        	if(node.next[c-'a'] == null) {
        		return false;
        	}
        	node = node.next[c-'a'];
        }
        return !(node.word == null);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this;
        char[] a = prefix.toCharArray();
        for(char c: a) {
        	if(node.next[c-'a'] == null) {
        		return false;
        	}
        	node = node.next[c-'a'];
        }
        return true;      
    }
    
    String word;
    Trie[] next = new Trie[26];
}

class TrieNode {
	
}
