class Solution {
    public int atMostNGivenDigitSet(String[] digits,int n){
        String N=String.valueOf(n);
        int m=digits.length;
        int ans=0;
        for(int i=1;i<N.length();i++){
            ans=ans+(int)Math.pow(m,i);
        }
        for(int i=0;i<N.length();i++){
            boolean sameDigitFound=false;
           for (String d:digits){
            char ch=d.charAt(0);
            if(ch<N.charAt(i)){
                ans=ans+(int)Math.pow(m,N.length()-i-1);
            }
           else if(ch==N.charAt(i)){
                sameDigitFound=true;
            }
           }
            if(!sameDigitFound){
                return ans;
            }
        }
        return ans+1;
    }
}