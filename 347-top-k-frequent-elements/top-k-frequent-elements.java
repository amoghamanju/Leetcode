class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqmap=new HashMap<>();
        for(int num:nums)
        {
            freqmap.put(num,freqmap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> minheap=new PriorityQueue<>((a,b)-> a.getValue()-b.getValue());

        for(Map.Entry<Integer,Integer> entry:freqmap.entrySet())
        {
            minheap.offer(entry);
            if(minheap.size()>k)
            {
                minheap.poll();
            }
        }
        int[] result=new int[k];
        int i=0;
        while(!minheap.isEmpty())
        {
            result[i++]=minheap.poll().getKey();
        }
        return result;

    }
}