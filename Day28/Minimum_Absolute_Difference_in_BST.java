class Solution {
    int min = Integer.MAX_VALUE;
    TreeNode prev;

    public int getMinimumDifference(TreeNode root) {
        inOrder(root);
        return min;
    }

    private void inOrder(TreeNode root){
        if(root == null) return;
        
        inOrder(root.left);

        if(prev != null){
            min = Math.min(min,root.val-prev.val);
        }
        prev = root;

        inOrder(root.right);
    }
}