class Solution {
    int pre=0, in=0;
    public TreeNode buildTree(int[] preOrder, int[] inOrder) {
        return helper(preOrder, inOrder, Integer.MIN_VALUE);
    }
    private TreeNode helper(int[] preOrder, int[] inOrder, int stop) {

        if(pre>=preOrder.length) return null;
        if(inOrder[in]==stop) {
            in++;
            return null;
        }
        TreeNode node=new TreeNode(preOrder[pre++]);
        node.left=helper(preOrder, inOrder, node.val);
        node.right=helper(preOrder, inOrder, stop);
        return node;
    }
}