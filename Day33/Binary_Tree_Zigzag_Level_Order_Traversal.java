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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean zigzag = false;

        while(!q.isEmpty()){
            List<Integer> lvl = new LinkedList<>();
            int cnt = q.size();

            for(int i=0; i<cnt; i++){
                TreeNode node = q.poll();

                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);

                if(zigzag) lvl.addFirst(node.val);
                else lvl.add(node.val);
            }
            res.add(lvl);
            zigzag = !zigzag;
        }
        return res;
    }
}