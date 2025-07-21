class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) {
            return paths;
        }

        dfs(root, "", paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        if (node == null) {
            return;
        }

        path += node.val;

        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }
        else{
            path += "->";
           dfs(node.left, path, paths);
           dfs(node.right, path, paths);
        }
    }    
}