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
    public TreeNode bstFromPreorder(int[] arr) {
        Stack<TreeNode> st = new Stack<>();
        if(arr.length == 1) return new TreeNode(arr[0]);
        TreeNode mainRoot = new TreeNode(arr[0]);
        TreeNode currRoot = mainRoot;
        int i = 1;
        while(i < arr.length && (!st.isEmpty() || currRoot != null)){
            while(i < arr.length && arr[i] < arr[i - 1]){
                TreeNode tempRoot = new TreeNode(arr[i]);
                currRoot.left = tempRoot;
                st.push(currRoot);
                currRoot = tempRoot;
                i++;
            }
            if(i >= arr.length) break;
            while(!st.isEmpty() && st.peek().val < arr[i]){
                currRoot = st.pop();
            }
            TreeNode temp = new TreeNode(arr[i]);
            i++;
            currRoot.right = temp;
            currRoot = currRoot.right;
        }
        return mainRoot;

    }
}