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
    private TreeNode first;
    private TreeNode middle;
    private TreeNode second;
    private TreeNode prev;

    public void inOrder(TreeNode root){
        if(root == null) return;

        inOrder(root.left);

        if(prev!= null && (root.val < prev.val)){
            if(first == null){
                first = prev;
                middle = root;
            }
            else {
                second = root;
            }
        }
        prev = root;
        inOrder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = second = middle = null;

        prev = new TreeNode(Integer.MIN_VALUE);

        inOrder(root);

        if(first != null && second != null){
           int t = first.val;
            first.val = second.val;
            second.val = t;
        }else if(first != null && middle != null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
            
        }
    }
}