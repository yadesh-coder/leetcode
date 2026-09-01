class Solution {
    public int subarraySum(int[] nums, int k) {
      HashMap<Integer,Integer>a=new HashMap<>();
        int maxl=0,sum=0;
        a.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(a.containsKey(sum-k)){
                maxl+=a.get(sum-k);
            }
            a.put(sum,a.getOrDefault(sum,0)+1);
        }
        return maxl;   
    }
}