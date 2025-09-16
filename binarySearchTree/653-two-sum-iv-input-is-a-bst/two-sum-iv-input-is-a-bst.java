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

    private Stack<TreeNode> stackBefore = new Stack<>();
    private Stack<TreeNode> stackNext = new Stack<>();

    public void pushAllForBefore(TreeNode root){
        while(root != null){
            this.stackBefore.push(root);
            root = root.right;
        }
    }

    public void pushAllForNext(TreeNode root){
        while(root != null){
            this.stackNext.push(root);
            root = root.left;
        }
    }

    public TreeNode next(){
        TreeNode temp = stackNext.pop();
        pushAllForNext(temp.right);
        return temp;
    }

    public TreeNode before(){
        TreeNode temp = stackBefore.pop();
        pushAllForBefore(temp.left);
        return temp;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        pushAllForNext(root);
        pushAllForBefore(root);
        TreeNode left = next();
        TreeNode right = before();

        while(left != right){
            if(left.val + right.val == k) return true;

            if(left.val + right.val < k) left = next();
            else right = before();
        }

        return false;

    }
}