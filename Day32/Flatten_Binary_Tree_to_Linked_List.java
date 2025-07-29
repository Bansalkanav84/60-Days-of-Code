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
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.right); // recursive call goes to rightmost i.e 6
        flatten(root.left);

        root.right = prev;  // 6 ka right is now null
        root.left  =a null;  // remove left child
        prev = root;   // now prev is 6, so when root is 5 => 5.right = 6 and so on
    }
}