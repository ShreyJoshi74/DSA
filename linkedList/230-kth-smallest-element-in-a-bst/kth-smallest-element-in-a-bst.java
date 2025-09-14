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
    int ans;
    int count=0;
    public void preorder(TreeNode root,int k){
        if(root == null) return;
        if(k <= 0) return;


        preorder(root.left,k);
        count++;
        if(count == k){
            ans = root.val;
            return;
        }
        preorder(root.right,k);
    }
    public int kthSmallest(TreeNode root, int k) {
     
        preorder(root,k);
        return this.ans;    
    }

}