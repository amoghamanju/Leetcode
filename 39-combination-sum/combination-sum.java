class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> results=new ArrayList<>();
        backtrack(0,candidates,target,new ArrayList<>(),results);
        return results;
    }
    private void backtrack(int index,int[] candidates,int target,List<Integer> current,List<List<Integer>> res)
    {
        if(target==0)
        {
            res.add(new ArrayList<>(current));
            return;
        }
        if(target<0 || index==candidates.length) return ;
        current.add(candidates[index]);
        backtrack(index, candidates,target-candidates[index],current,res);
        current.remove(current.size()-1);

        backtrack(index+1,candidates,target,current,res);
    }
}