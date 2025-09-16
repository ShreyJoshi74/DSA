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
class BSTIterator {
    TreeNode root;
    TreeNode curr;
    TreeNode successor;
    public BSTIterator(TreeNode root) {
        this.root = root;
        this.curr = null;
        this.successor = null;
    }
    
    public int next() {
        if(!hasNext()) return -1;
        if(this.curr == null){
            TreeNode temp = root;
            while(temp != null){
                this.curr = temp;
                temp=temp.left;
            }
            return curr.val;
        }else{
            successor = null;
            TreeNode temp = root;
            while(temp != null){
                if(curr.val < temp.val){
                    successor = temp;
                    temp = temp.left;
                }else{
                    temp = temp.right;
                }
            }
            this.curr = successor;
            return this.curr.val;
        }
    }
    
    public boolean hasNext() {
        if(curr == null && root == null)  return false;
        if(curr == null) return true;
        TreeNode temp = root;
        while(temp != null){
            if(temp.val <= this.curr.val){
                temp = temp.right;
            }else return true;
        }
        return false;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */