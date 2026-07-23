class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for (int num:nums) {
            sum+=num;
        }
        if (Math.abs(target)>sum||(target+sum)%2!=0) {
            return 0;
        }
        int subsetSum=(target+sum)/2;
        int m=nums.length;
        int[][] dp=new int[m+1][subsetSum+1];
        dp[0][0]=1; 
        for (int i=1;i<=m;i++) {
            for (int j=0;j<=subsetSum;j++) {
                if (nums[i-1]>j) {
                    dp[i][j]=dp[i-1][j];
                } else {
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[m][subsetSum];
    }
}