class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null) return res;
        find(root, res, new ArrayList<>(), targetSum);
        return res;
    }

    private void find(TreeNode root, List<List<Integer>> res, List<Integer> path, int target){
        if(root == null) return;
        path.add(root.val);

        if(root.left == null && root.right == null && target == root.val){
            res.add(new ArrayList<>(path));
        }
        else{
           find(root.left, res, path, target - root.val);
           find(root.right, res, path, target - root.val);
        }

        path.remove(path.size()-1);
    }
}