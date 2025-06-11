class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights.length==0 || heights[0].length==0)
        {
            return new ArrayList<>();
        }
        int row=heights.length;
        int col=heights[0].length;


        boolean[][] pacificreachable=new boolean[row][col];
        boolean[][] atlanticreachable=new boolean[row][col];

        for(int i=0;i<row;i++)
        {
            dfs(i,0,pacificreachable, heights);
            dfs(i,col-1,atlanticreachable, heights);
        }
        for(int i=0;i<col;i++)
        {
            dfs(0,i,pacificreachable, heights);
            dfs(row-1,i,atlanticreachable, heights);
        }
        List<List<Integer>> result=new ArrayList<>();

        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(pacificreachable[i][j] && atlanticreachable[i][j])
                {
                    result.add(List.of(i,j));
                }
            }
        }
        return result;
    }
    public void dfs(int row, int col, boolean[][] reachable, int [][] heights)
    {
        int[][] directions=new int[][]{{0,1},{1,0},{-1,0},{0,-1}};

        reachable[row][col]=true;

        for(int[] dir:directions)
        {
            int newrow=row+dir[0];
            int newcol=col+dir[1];


            if(newrow<0|| newrow>=heights.length || newcol<0 || newcol>=heights[0].length)
            {
                continue;
            }
            if(reachable[newrow][newcol])
            {
                continue;
            }
            if(heights[newrow][newcol]>=heights[row][col])
            {
                dfs(newrow,newcol,reachable,heights);
            }
        }
    }
}