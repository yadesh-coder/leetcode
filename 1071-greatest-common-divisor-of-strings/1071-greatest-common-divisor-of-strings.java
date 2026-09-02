class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int a=str1.length();
        int b=str2.length();
        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        if((str1+str2).equals(str2+str1)){
            String ans=str1.substring(0,a);
            return ans;            
        }
        else{
            return "";
        }
    }
}