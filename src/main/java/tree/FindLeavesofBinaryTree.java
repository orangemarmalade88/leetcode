package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import model.TreeNode;

public class FindLeavesofBinaryTree {
    Map<TreeNode, TreeNode> parent = new HashMap<>();
    Map<TreeNode, Integer> count_map = new HashMap<>();
    Queue<TreeNode> leaves = new LinkedList<>();

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root);
        while (!leaves.isEmpty()) {
            List<Integer> l = new ArrayList<>();
            int size = leaves.size();
            while (size-- > 0) {
                TreeNode t = leaves.poll();
                l.add(t.val);
                TreeNode par = parent.getOrDefault(t, null);
                if (par != null) {
                    int count = count_map.get(par);
                    count_map.put(par, count - 1);
                    if (count - 1 == 0)
                        leaves.add(par);
                }
            }
            result.add(l);
        }
        return result;
    }

    public void dfs(TreeNode root) {
        if (root == null)
            return;
        int count = 0;
        if (root.left != null) {
            parent.put(root.left, root);
            dfs(root.left);
            count++;
        }
        if (root.right != null) {
            parent.put(root.right, root);
            dfs(root.right);
            count++;
        }
        if (count == 0)
            leaves.add(root);
        count_map.put(root, count);
    }

}
