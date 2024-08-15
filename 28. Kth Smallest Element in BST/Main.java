public class Main {
    int i;
    int[] arr;

    public int kthSmallest(TreeNode root, int k) {
        i = 0;
        arr = new int[k];
        process(root);
        return arr[arr.length - 1];
    }

    public void process(TreeNode root) {
        if (root == null)
            return;
        if (i == arr.length)
            return;
        process(root.left);
        if (i < arr.length)
            arr[i++] = root.val;
        process(root.right);
    }
}
