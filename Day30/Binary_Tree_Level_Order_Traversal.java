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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();

        if(root == null) return levels;
        
        q.offer(root);
        while(!q.isEmpty()){
            int nodes = q.size();
            List<Integer> sublvl = new LinkedList<>();

            for(int i=0; i<nodes; i++){
                if(q.peek().left != null) q.offer(q.peek().left);
                if(q.peek().right != null) q.offer(q.peek().right);
                sublvl.add(q.poll().val);
            }
            levels.add(sublvl);
        }
        return levels; 
    }
}