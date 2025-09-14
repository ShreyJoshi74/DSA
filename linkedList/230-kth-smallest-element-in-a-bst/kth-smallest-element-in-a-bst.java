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
    public void preorder(TreeNode root,List<Integer> ls,int k){
        if(root == null) return;
        if(ls.size() >= k) return;
        preorder(root.left,ls,k);
        ls.add(root.val);
        if(ls.size() >= k) return;
        preorder(root.right,ls,k);
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> ls = new ArrayList<>();
        preorder(root,ls,k);
        return ls.get(k - 1);    
    }

}