class Solution {
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount+1];
    Arrays.fill(dp,-1);
    dp[0]=0;
    for (int coin:coins) {
        for (int j=1;j<=amount;j++){
            if (j>=coin&&dp[j-coin]!=-1){
                if (dp[j]==-1) {
                   dp[j]=1+dp[j-coin];
                } else {
                    dp[j]=Math.min(dp[j],1+dp[j-coin]);
                }
              }
         }
      }
    return dp[amount];
    }
}