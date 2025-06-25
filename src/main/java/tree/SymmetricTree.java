package tree;

import model.TreeNode;

public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null)
            return true;
        if (right == null || left == null)
            return false;
        if (left.val != right.val)
            return false;
        return isMirror(left.left, right.right)
                && isMirror(left.right, right.left);
    }
}
