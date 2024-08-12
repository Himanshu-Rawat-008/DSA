public class Main {
    List<Integer> res;

    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
        if (root == null)
            return res;
        res.add(root.val);
        process(root, 2);
        return res;
    }

    public void process(TreeNode root, int level) {
        if (root == null)
            return;
        if (root.left == null && root.right == null)
            return;

        if (res.size() < level) {
            if (root.right != null)
                res.add(root.right.val);
            else
                res.add(root.left.val);
        }
        process(root.right, level + 1);
        process(root.left, level + 1);
    }
}
