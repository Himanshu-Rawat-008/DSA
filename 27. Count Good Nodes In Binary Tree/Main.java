public class Main {
    public int goodNodes(TreeNode root) {
        return process(root, Integer.MIN_VALUE);
    }

    public int process(TreeNode root, int max) {
        if(root == null) return 0;
        int curr = max;
        if(root>= max)
            curr = root.val
        int l = process(root.left, curr);
        int r = process(root.right, curr);

        return curr == root.val ? 1 + l + r;
    }
}
