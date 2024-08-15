public class Main {
    boolean res;

    public int process(TreeNode root) {
        if (root == null)
            return 0;
        int left = process(root.left);
        int right = process(root.right);
        if (left > right && left - right > 1)
            res = false;
        else if (right - left > 1)
            res = false;

        return 1 + Math.max(left, right);
    }

    public boolean isBalanced(TreeNode root) {
        res = true;
        process(root);
        return res;
    }
}
