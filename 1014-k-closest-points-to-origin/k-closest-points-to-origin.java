class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap=new PriorityQueue<>(
            (a,b) ->Integer.compare(b[0]*b[0]+b[1]*b[1],a[0]*a[0]+a[1]*a[1]));
        
        for(int[] point:points)
        {
            maxheap.add(point);
            if(maxheap.size()>k)
            {
                maxheap.poll();
            }
        }

        //collect the closest points
        int[][] result=new int[k][2];
        for(int i=0;i<k;i++)
        {
            result[i]=maxheap.poll();
        }
        return result;

    }
}