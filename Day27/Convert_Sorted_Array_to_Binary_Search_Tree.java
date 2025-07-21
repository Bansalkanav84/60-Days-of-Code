class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;   

        TreeNode root = createTree(nums,0,nums.length-1);
        return root;   
    }

    private TreeNode createTree(int[] num, int start , int end){
        if(start > end) return null;

        int mid = (start+end)/2;
        TreeNode node = new TreeNode(num[mid]);

        node.left = createTree(num,start,mid-1);
        node.right = createTree(num,mid+1,end);
        return node;
    }
}