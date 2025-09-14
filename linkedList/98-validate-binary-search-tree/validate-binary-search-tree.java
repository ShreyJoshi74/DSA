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
    long prev = Long.MIN_VALUE;
    public boolean isValid(TreeNode root){
        if(root == null) return true;
        boolean A = isValid(root.left);
        boolean B = true;
        if(prev >= root.val) B = false;
        prev = root.val;
        boolean C = isValid(root.right);
        return A & B & C;
    }
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        return isValid(root);
    }
}