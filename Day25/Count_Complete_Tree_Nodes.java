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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }

        int lh = left_height(root);
        int rh = right_height(root);

        if(lh == rh){
            return (1 << lh) - 1;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int left_height(TreeNode root){
        int ht = 0;

        while(root != null){
            ht++;
            root = root.left;
        }
        return ht;
    }

    private int right_height(TreeNode root){
        int ht = 0;

        while(root != null){
            ht++;
            root = root.right;
        }
        return ht;
    }
}