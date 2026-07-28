class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        boolean pastNull=false;
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            if(curr==null)
            pastNull=true;
            else{
                if(pastNull==true)
                return false;
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        return true;
    }
}