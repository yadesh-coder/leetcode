class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> a=new HashMap<>();
        int maxlen=0,left=0;
        for(int right=0;right<s.length();right++){
            char currentChar=s.charAt(right);
            if(a.containsKey(currentChar)){
                left=Math.max(left,a.get(currentChar)+1);
            }
            a.put(currentChar,right);
            maxlen=Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
}