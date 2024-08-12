public class Main {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        if (root.left == null && root.right == null)
            return root;

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.left = rightNode;
        root.right = leftNode;
        return root;
    }

    public static void main(String[] args) {

    }
}
