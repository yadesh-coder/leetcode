class Solution {
    void dfs(TreeNode r1,TreeNode r2,int level){
        if(r1==null||r2==null)
        return;
        if(level%2==1){
            int temp=r1.val;
            r1.val=r2.val;
            r2.val=temp;
        }
        dfs(r1.left,r2.right,level+1);
        dfs(r1.right,r2.left,level+1);
    }
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left,root.right,1);
        return root;
    }
}