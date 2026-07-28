class Solution {
    public boolean isBalanced(TreeNode root){
       return heightDiff(root)!=-1; 
    }
    public int heightDiff(TreeNode root){
        if(root==null)
        return 0;
        int l=heightDiff(root.left);
        int r=heightDiff(root.right);
        if(l==-1||r==-1)
        return -1;
        if(Math.abs(l-r)>1)
        return -1;
        return 1+Math.max(l,r);
    }
}