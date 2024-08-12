public enum Main {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        if(root == null) return arr;

        List<TreeNode> curr = new ArrayList<>();
        curr.add(root);
        while(curr.size() > 0) {
            List<TreeNode> temp = new ArrayList<>();
            List<Integer> prevLevel = new ArrayList<>();
            for(int i =0;i<curr.size();i++) {
                TreeNode r = curr.get(i);
                prevLevel.add(r.val);
                if(r.left != null) temp.add(r.left);
                if(r.right != null) temp.add(r.right); 
            }
            arr.add(prevLevel);
            curr = temp;
        }

        return arr;
    }
}
