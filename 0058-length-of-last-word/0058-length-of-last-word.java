class Solution {
    public int lengthOfLastWord(String s) {
        int n=s.length()-1;
        String sub;
        int size;
        int j=s.length()-1;
        while(j>=0&&s.charAt(j)==' '){
            j--;
            n--;
        }
        for(int i=n;i>=0;i--)
        {
            if(s.charAt(i)==' ')
            {
            sub=s.substring(i+1,n+1);
            return sub.length();
            }
        }
        return n+1;
    }
}