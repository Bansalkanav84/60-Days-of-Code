class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return height(root).getValue();
    }
    
    private Pair<Integer, TreeNode> height(TreeNode root) {
        if (root == null) return new Pair(0, null);
        
        Pair<Integer, TreeNode> left = height(root.left);
        Pair<Integer, TreeNode> right = height(root.right);
        
        int leftHeight = left.getKey();
        int rightHeight = right.getKey();
        if (leftHeight == rightHeight) {
            return new Pair(leftHeight + 1, root);
        } else if (leftHeight < rightHeight) {
            return new Pair(rightHeight + 1, right.getValue());
        } else {
            return new Pair(leftHeight + 1, left.getValue());
        }
    }
}