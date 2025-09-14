/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    TreeNode ans = null;
    public boolean find(TreeNode root,TreeNode p, TreeNode q){
        if(root == null) return false;
        boolean found = false,left = false,right = false;
        if(root == p || root == q) found = true;
        left = find(root.left,p,q);
        right = find(root.right,p,q);

        if(left && right || left && found || right && found) ans = root;

        return found | right | left;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;

        find(root,p,q);

        return this.ans;
    }
}