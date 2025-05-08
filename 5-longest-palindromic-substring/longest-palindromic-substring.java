class Solution {
    public String longestPalindrome(String s) {
        int start=0,end=0,len1=0,len2=0;
        for(int i=0;i<s.length();i++)
        {
            len1=maxlen(s,i,i);
            len2=maxlen(s,i,i+1);
            int len=Math.max(len1,len2);

            if(len>end-start)
            {
                start=i-(len-1)/2;
                end=i+len/2;
            }
        }
        return s.substring(start,end+1);
    }
    //"a"- length=1, "ab", start =0 end =1 length=2
    public int maxlen(String s,int start, int end)
    {
        while(start>=0 && end<s.length() && s.charAt(start)==s.charAt(end))
        {
            start--;
            end++;
        }
        return end-start-1;
    }
}