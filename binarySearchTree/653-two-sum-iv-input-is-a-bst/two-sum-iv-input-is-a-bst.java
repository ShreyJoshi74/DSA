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
    public boolean findTarget(TreeNode root, int k) {
        Stack<TreeNode> st = new Stack<>();
        ArrayList<Integer> ls =new ArrayList<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            ls.add(root.val);
            root = root.right;
        }
        int i = 0;
        int j = ls.size()-1;
        while(i < j){
            int a = ls.get(i);
            int b = ls.get(j);
            if(a + b == k) return true;
            if(a + b < k) i++;
            else j--; 
        }
        return false;
        
    }
}