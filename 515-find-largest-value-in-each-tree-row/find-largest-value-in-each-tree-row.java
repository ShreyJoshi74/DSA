/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> list = new ArrayList<>();
        dfs(list,0,root);
        return list;
    }
    public void dfs(List<Integer> list, int level,TreeNode root){
        if(root == null){
            return;
        }
        if(level == list.size()){
            list.add(root.val);
        }
        list.set(level, Math.max(list.get(level), root.val));

        dfs(list,level+1,root.left);
        dfs(list,level+1,root.right);
    }
}