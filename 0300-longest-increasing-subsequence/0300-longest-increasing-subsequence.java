class Solution {
    private int lowerBound(List<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size(); 
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    public int lengthOfLIS(int[] nums) {
        List<Integer> tails = new ArrayList<>();
        for (int num : nums) {
            int pos = lowerBound(tails, num);
            if (pos == tails.size()) {
                tails.add(num); 
            } else {
                tails.set(pos, num); 
            }
        }
        return tails.size();
    }
}