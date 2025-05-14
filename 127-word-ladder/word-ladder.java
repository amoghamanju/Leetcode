class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordset=new HashSet<>(wordList);
        if(!wordset.contains(endWord))
        {
            return 0;
        }
        Queue<String> queue=new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited=new HashSet<>();
        visited.add(beginWord);
        int step=1;
        while(!queue.isEmpty())
        {
            int size=queue.size();
            for(int i=0;i<size;i++)
            {
                String current=queue.poll();
                char[] wordArray=current.toCharArray();
                for(int j=0;j<wordArray.length;j++)
                {
                    char originalChar=wordArray[j];
                    for(char c='a';c<='z';c++)
                    {
                        wordArray[j]=c;
                        String nextWord=new String(wordArray);
                        if(nextWord.equals(endWord)) return step+1;

                        if(wordset.contains(nextWord) && !visited.contains(nextWord))
                        {
                            visited.add(nextWord);
                            queue.offer(nextWord);
                        }
                    }
                    wordArray[j]=originalChar;
                }
                
            }
            step++;
        }
        return 0;
    }
}