public class Main {
    int max;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        process(root);
        return max;
    }

    public int process(TreeNode root) {
        if (root == null)
            return 0;
        int left = process(root.left);
        int right = process(root.right);

        int l1 = root.val;
        int l2 = left + root.val;
        int l3 = right + root.val;
        int l4 = left + right + root.val;

        int res1 = Math.max(l1, Math.max(l2, l3));
        int res2 = Math.max(res1, l4);
        if (res2 > max)
            max = res2;
        if (res1 > max)
            max = res1;
        return res1 < 0 ? 0 : res1;
    }
}
