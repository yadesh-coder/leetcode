class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        if(g.length==0 || s.length==0){
            return 0;
        }
        int i=0,j=0,count=0;
        while(i<s.length && j<g.length){
            if(s[i]>=g[j]){
                count++;
                j++;
            }
            i++;
        }
        return count;
    }
}