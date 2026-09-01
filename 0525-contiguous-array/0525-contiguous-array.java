class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer>a=new HashMap<>();
        a.put(0,-1);
        int maxl=0,sum=0;
        for(int i=0;i<nums.length;i++){
           sum += (nums[i] == 1) ? 1 : -1; 
            if(a.containsKey(sum)){
                maxl=Math.max(maxl,i-a.get(sum));
            }
            else{
                a.put(sum,i);
            }
        }
        return maxl;
    }
}