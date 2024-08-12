public class Main {
    List<Integer> inorder;

    public boolean isValidBST(TreeNode root) {
        inorder = new ArrayList<>();
        process(root);
        for (int i = 1; i < inorder.size(); i++)
            if (inorder.get(i) <= inorder.get(i - 1))
                return false;
        return true;
    }

    public void process(TreeNode root) {
        if (root == null)
            return;
        process(root.left);
        inorder.add(root.val);
        process(root.right);
    }
}
