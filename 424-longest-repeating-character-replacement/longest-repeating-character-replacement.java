class Solution {
    public int characterReplacement(String s, int k) {
        int[]count=new int[26];
        int left=0,right=0,maxlength=0, maxcount=0;
        for(right=0;right<s.length();right++)
        {
            char ch=s.charAt(right);
            count[ch-'A']++;
            maxcount=Math.max(maxcount,count[ch-'A']);

            while((right-left+1)-maxcount>k)
            {
                count[s.charAt(left)-'A']--;
                left++;
            }
            maxlength=Math.max(maxlength,(right-left+1));
        }
        return maxlength;
    }
}