class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen=new HashSet<>();
        int start=0,end=0,maxlen=0;
        while(end<s.length())
        {
            char ch=s.charAt(end);
            if(!seen.contains(ch))
            {
                seen.add(ch);
                maxlen=Math.max(maxlen,end-start+1);
                end++;
            }
            else
            {
                seen.remove(s.charAt(start));
                start++;
            }
        }
        return maxlen;
    }
}