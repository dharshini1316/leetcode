class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = getTotalSum(root);
        computeMaxProduct(root);
        return (int)(maxProduct % MOD);
    }

    private long getTotalSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + getTotalSum(node.left) + getTotalSum(node.right);
    }

    private long computeMaxProduct(TreeNode node) {
        if (node == null) return 0;

        long leftSum = computeMaxProduct(node.left);
        long rightSum = computeMaxProduct(node.right);

        long subTreeSum = node.val + leftSum + rightSum;

        long product = subTreeSum * (totalSum - subTreeSum);
        maxProduct = Math.max(maxProduct, product);

        return subTreeSum;
    }
}