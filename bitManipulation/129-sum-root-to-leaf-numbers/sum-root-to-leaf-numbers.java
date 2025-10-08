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
    public int f(TreeNode root, int number){
        if(root == null) return 0;
        if(root.left == null && root.right == null) {
            if(number == -1) return root.val;
            int currentValue = number * 10 + root.val;
            return currentValue;
        }
        int currentValue;
        if(number == -1) currentValue = root.val;
        else currentValue = number * 10 + root.val;
        int left = 0;
        int right = 0;
        if(root.left != null) left = f(root.left,currentValue);
        if(root.right != null) right = f(root.right,currentValue);
        return left + right;
    }
    public int sumNumbers(TreeNode root) {
        return f(root,-1);
    }
}