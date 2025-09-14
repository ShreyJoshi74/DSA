class Solution {
    public boolean isValidBST(TreeNode root) {
        long prev = Long.MIN_VALUE;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                // Visit node
                if (curr.val <= prev) return false;
                prev = curr.val;
                curr = curr.right;
            } else {
                // Find inorder predecessor
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                if (pred.right == null) {
                    // Threading
                    pred.right = curr;
                    curr = curr.left;
                } else {
                    // Remove threading
                    pred.right = null;
                    if (curr.val <= prev) return false;
                    prev = curr.val;
                    curr = curr.right;
                }
            }
        }

        return true;
    }
}
