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
    List<List<Integer>> result = new ArrayList<>();
    public void dfs (TreeNode root, int targetSum, List<Integer> ls){
        if(root.left == null && root.right == null){
            if(targetSum == root.val){
                List<Integer> path = new ArrayList<>();
                for(int temp : ls) path.add(temp);
                path.add(root.val);
                result.add(path);
            }
            return;
            
        }
        ls.add(root.val);
            if(root.left != null)dfs(root.left,targetSum - root.val,ls);
            if(root.right != null)dfs(root.right,targetSum - root.val,ls);
            ls.remove(ls.size()-1);
            return;
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root == null) return result;
        List<Integer> ls = new ArrayList<>();
        dfs(root,targetSum,ls);
        return result;
    }
}