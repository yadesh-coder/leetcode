class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (num % k == 0) {
                set.add(num / k);
            }
        }

        for (int i = 1; ; i++) {
            if (!set.contains(i)) {
                return i * k;
            }
        }
    }
}