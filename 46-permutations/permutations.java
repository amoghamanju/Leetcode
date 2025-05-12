class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        backtrack(nums,new ArrayList<>(),result,new boolean[nums.length]);
        return result;
    }
    private void backtrack(int[]nums, List<Integer> path, List<List<Integer>> res,boolean[] used)
    {
        if(path.size()==nums.length)
        {
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(used[i]) continue;
            path.add(nums[i]);
            used[i]=true;
            backtrack(nums,path,res,used);
            path.remove(path.size()-1);
            used[i]=false;
        }

    }
}