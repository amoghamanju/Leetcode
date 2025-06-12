class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();
        int[] indegree=new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }

        //plotting edges
        for(int[] pre:prerequisites)
        {
            graph.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        //lets play with queue
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                queue.offer(i); //if no prereq then we start with that course
            }
        }

        //topological order
        List<Integer> order=new ArrayList<>();
        while(!queue.isEmpty())
        {
            int course=queue.poll();
            order.add(course);

            for(int neighbour:graph.get(course))
            {
                indegree[neighbour]--;
                if(indegree[neighbour]==0)
                {
                    queue.offer(neighbour); //if no prereq then we start with that course
                }
            }
        }

        if(order.size()==numCourses)
        {
            int[] result=new int[numCourses];
            for(int i=0;i<numCourses;i++)
            {
                result[i]=order.get(i);
            }
            return result;
        }
        else
        {
            return new int[0];
        }
    }
}