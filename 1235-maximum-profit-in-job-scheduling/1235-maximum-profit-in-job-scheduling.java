class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit){
        int n = startTime.length;
        int[][] jobs = new int[n][3];
        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }
        Arrays.sort(jobs, (a, b) -> Integer.compare(a[1], b[1]));
        int[] dp = new int[n];
        dp[0] = jobs[0][2];
        for (int i = 1; i < n; i++) {
            int skip = dp[i - 1];
            int take = jobs[i][2];
            int j = findLastNonOverlappingJob(jobs, i, jobs[i][0]);
            if (j != -1) {
                take += dp[j];
            }
            dp[i] = Math.max(skip, take);
        }
        return dp[n - 1];
    }
    private int findLastNonOverlappingJob(int[][] jobs, int index, int startTime) {
        int low = 0;
        int high = index - 1;
        int answer = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (jobs[mid][1] <= startTime) {
                answer = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return answer;
    }
}