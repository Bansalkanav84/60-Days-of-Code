/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {        
        return exists(root,targetSum);
    }

    private boolean exists(TreeNode root, int target){
        if(root == null) return false;
        if(root.left == null && root.right == null && target == root.val) return true;

        return exists(root.right, target-root.val) || exists(root.left, target-root.val);
    }
}