package tree;

import java.util.ArrayList;
import java.util.List;

import model.TreeNode;

public class FindLeavesofBinaryTree {
    public List<List<Integer>> result = new ArrayList<>();

    private int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        int left = getHeight(root.left);
        int right = getHeight(root.right);

        int h = Math.max(left, right) + 1;

        if (result.size() == h)
            result.add(new ArrayList<>());

        result.get(h).add(root.val);

        return h;
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        getHeight(root);

        return result;
    }

}
