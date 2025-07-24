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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return search(root, p, q);
    }

    public TreeNode search(TreeNode curr, TreeNode p, TreeNode q)
    {
        if (curr == null) return null;
        else if (curr == p || curr == q) return curr;

        TreeNode left = search(curr.left, p, q);
        TreeNode right = search(curr.right, p, q);

        if(left == null) return right;
        else if(right == null) return left;
        else return curr;
    }    
}