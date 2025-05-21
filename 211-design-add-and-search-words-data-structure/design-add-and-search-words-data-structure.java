class WordDictionary {

    public static class TrieNode{
        TrieNode[] children=new TrieNode[26];
        boolean isEndOfWord=false;
    }
    private final TrieNode root;
    public WordDictionary() {
        root= new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode current=root;
        for(char ch:word.toCharArray())
        {
            int index=ch-'a';
            if(current.children[index]==null)
            {
                current.children[index]=new TrieNode();
            }
            current=current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        return dfssearch(word, 0, root);
    }
    private boolean dfssearch(String word,int pos,TrieNode node)
    {
        if(node==null) return false;
        if(pos==word.length())
        {
            return node.isEndOfWord;
        }
        char ch=word.charAt(pos);

        if(ch=='.')
        {
            for(TrieNode child:node.children)
            {
                if(child!=null && dfssearch(word,pos+1,child))
                {
                    return true;
                }
            }
            return false;
        }
        else
        {
            int index=ch-'a';
            return dfssearch(word,pos+1,node.children[index]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */