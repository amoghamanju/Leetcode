class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> anmap=new HashMap<>();
        for(String word:strs)
        {
            int[] count=new int[26];
            for(char c:word.toCharArray())
            {
                count[c-'a']++;
            }
            StringBuilder keyBuilder=new StringBuilder();
            for(int freq:count)
            {
                keyBuilder.append(freq).append('#');
            }
            String key=keyBuilder.toString();
            anmap.computeIfAbsent(key,k->new ArrayList<>()).add(word);
        }
        return new ArrayList<>(anmap.values());
    }
}