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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        if(root.left == null && root.right == null) return 1;
        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        int maxLevel = -1;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.addLast(root);

        while(!dq.isEmpty()){
            level++;
            int sum = 0;
            int k = dq.size();
            for(int i = 0; i < k; i++){
                TreeNode temp = dq.pollFirst();
                sum += temp.val;
                if(temp.left != null) dq.addLast(temp.left);
                if(temp.right != null) dq.addLast(temp.right);
            }
            if(sum > maxSum){
                maxLevel = level;
                maxSum = sum;
            }
        }
        return maxLevel;
    }
}