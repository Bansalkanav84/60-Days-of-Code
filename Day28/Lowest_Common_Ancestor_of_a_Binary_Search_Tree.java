/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val <= q.val) return find(root,p,q);
        else return find(root,q,p);
    }

    private TreeNode find(TreeNode root, TreeNode low, TreeNode high){
        if(root.val < low.val) return find(root.right,low,high); // Search in right subtree
        else if(root.val > high.val) return find(root.left,low,high); // Search in left subtree
        return root;  // if nothing, return root
    }
}