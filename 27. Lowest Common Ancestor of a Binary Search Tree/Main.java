public class Main {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (p.val == root.val)
            return root;
        if (q.val == root.val)
            return root;

        if (left != null && right != null && left.val != right.val) {
            return root;
        }
        if (left == null)
            return right;
        return left;
    }
}
