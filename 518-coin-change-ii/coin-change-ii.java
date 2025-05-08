class Solution {
    
    public int change(int amount, int[] coins) {
        Integer[][]dp=new Integer[coins.length][amount+1];
        return countways(coins,0,amount,dp);
    }
    private int countways(int[] coins,int index, int amount, Integer[][]dp)
    {
        if (amount==0) return 1;
        if(index==coins.length || amount<0) return 0;
        if(dp[index][amount]!=null) return dp[index][amount];
        int pick=countways(coins,index,amount-coins[index],dp);
        int notpick=countways(coins,index+1, amount,dp);

        return dp[index][amount]=pick+notpick;
    }
}