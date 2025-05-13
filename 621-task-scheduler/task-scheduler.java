class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c:tasks)
        {
            freq[c-'A']++;
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int f:freq)
        {
            if(f>0)
            {
                pq.add(f);
            }
        }
        int time=0;
        Queue<int[]> cooldown=new LinkedList<>();
        while(!pq.isEmpty() || !cooldown.isEmpty())
        {
            time++;
            if(!pq.isEmpty())
            {
                int rem=pq.poll()-1;
                if(rem>0)
                {
                    cooldown.add(new int[]{rem, time+n});
                }
            }
            if(!cooldown.isEmpty() && cooldown.peek()[1]==time)
            {
                pq.add(cooldown.poll()[0]);
            }
        }
        return time;
    }
}