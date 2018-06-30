package addAndSearchWord211;

public class test {
	public static void main(String[] args) {
		WordDictionary dic = new WordDictionary();
		
		dic.addWord("wen");
		dic.addWord("yi");
		dic.addWord("ming");
		
		System.out.println(dic.search("yin"));
		System.out.println(dic.search("w.n"));
	}
}


class WordDictionary {

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
    	TrieNode node = root;
        char[] a = word.toCharArray();
        for(char c : a) {
        	if(node.next[c-'a'] == null) {
        		node.next[c-'a'] = new TrieNode();
        	}
        	node = node.next[c-'a'];
        }
        node.word = word;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
    	char[] a = word.toCharArray();
        return searchByBackTracking(a, root, 0);
    }
    
    private boolean searchByBackTracking(char[] a, TrieNode root, int startPos) {
    	if(startPos == a.length) return !(root.word==null);
    	if(a[startPos] != '.') {
    		return root.next[a[startPos]-'a'] != null && searchByBackTracking(a, root.next[a[startPos]-'a'], startPos+1);
    	} else {
    		for(int i=0; i<26; i++) {
    			//ע������Ļ��ݣ�
    			if(root.next[i] != null) {
    				//ֻҪ����һ��iΪtrue���ͷ���true
    				//���ֱ��return searchByBackTracking, �Ǿ�ֻ���жϵ�һ����
    				//�����DFS����˵Ҳ�ǻ��ݵ�˼�룬����������ֻ�����������ĲŻ᷵�أ����ݵĻ���ÿ��������
    				if(searchByBackTracking(a, root.next[i], startPos+1)) {
    					return true;
    				}
    			}
    		}
    	}
    	
    	return false;
    }
    
    TrieNode root;
}


class TrieNode {
	String word;
	TrieNode[] next = new TrieNode[26];
}

