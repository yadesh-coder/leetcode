import java.lang.*;
class Solution {
    public boolean isValid(int[] weights, int days, int mid) {
        int load=0;
        int day=1;
        for (int i=0;i<weights.length;i++) {
            if (weights[i]>mid) 
            return false;
            if (load+weights[i]>mid) {
                day++;
                load=weights[i];
            } 
            else
                load=load+weights[i];
        }
        if(day<=days)
        return true;
        else
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int maximum=0;
        int maxWeight=0;
        for (int i=0;i<weights.length;i++) {
            maximum=maximum+weights[i];
            maxWeight=Math.max(maxWeight,weights[i]);
        }
        int low=maxWeight;
        int high=maximum;
        int ans=-1;
        while(low<=high) {
            int mid=low+(high-low)/2;
            if (isValid(weights,days,mid)) {
                ans=mid;
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return ans;
    }
}