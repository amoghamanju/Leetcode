class Solution {
    public String minWindow(String s, String t) {
        if(s.length()<t.length()) return "";
        Map<Character,Integer> tfreq=new HashMap<>();
        for(char c:t.toCharArray())
        {
            tfreq.put(c,tfreq.getOrDefault(c,0)+1);
        }
        int left=0,right=0,count=0;
        int minlen=Integer.MAX_VALUE, start=0;

        Map<Character,Integer> windowfreq=new HashMap<>();
        while(right<s.length())
        {
            char rchar=s.charAt(right);
            windowfreq.put(rchar,windowfreq.getOrDefault(rchar,0)+1);

            if(tfreq.containsKey(rchar) && windowfreq.get(rchar).intValue()==tfreq.get(rchar).intValue())
            {
                count++;
            }
            while(count==tfreq.size())
            {
                if(right-left+1<minlen)
                {
                    minlen=right-left+1;
                    start=left;
                }
                char lchar=s.charAt(left);
                windowfreq.put(lchar, windowfreq.get(lchar) - 1);
                if(tfreq.containsKey(lchar) && windowfreq.get(lchar).intValue()<tfreq.get(lchar).intValue())
                {
                    count--;
                }
                left++;
            }
            right++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(start, start + minlen);
    }
}