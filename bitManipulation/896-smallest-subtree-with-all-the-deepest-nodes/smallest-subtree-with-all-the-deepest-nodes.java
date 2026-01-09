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
    TreeNode node;
    public int height(TreeNode root){
        if(root == null) return 0;

        return 1 + Math.max(height(root.left),height(root.right));
    }
    public TreeNode findNode(TreeNode root){
        
        if(root.left == null && root.right == null) return root;

        int left = height(root.left);
        int right = height(root.right);

        if(left == right) 
            return root;
        if(left > right)
            return findNode(root.left);
        else
            return findNode(root.right);
        
        

    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return findNode(root);
    }
}