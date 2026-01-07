class Solution {
    long totalSum;
    long maxProduct = 0;

    public long findProduct(TreeNode root){
        if (root == null) return 0;

        long ans = 0;
        ans += findProduct(root.left);
        ans += findProduct(root.right);

        return ans + root.val;
    }

    public long preOrder(TreeNode root){
        if (root == null) return 0;

        long left = preOrder(root.left);
        long right = preOrder(root.right);

        long subSum = left + right + root.val;
        maxProduct = Math.max(maxProduct, subSum * (totalSum - subSum));

        return subSum;
    }

    public int maxProduct(TreeNode root) {
        totalSum = findProduct(root);
        preOrder(root);
        return (int)(maxProduct % 1_000_000_007);
    }
}
