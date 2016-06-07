package tree.traversal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import model.TreeNode;

public class BinaryTreeVerticalOrderTraversal {
	public List<List<Integer>> verticalOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		if (root == null)
			return result;
		Queue<TreeNode> queue = new LinkedList<>();
		Queue<Integer> cols = new LinkedList<>();
		queue.offer(root);
		cols.offer(0);
		int max = 0;
		int min = 0;
		while (!queue.isEmpty()) {
			TreeNode current = queue.poll();
			int col = cols.poll();
			max = Math.max(max, col);
			min = Math.min(min, col);

			if (!map.containsKey(col))
				map.put(col, new ArrayList<Integer>());
			map.get(col).add(current.val);

			if (current.left != null) {
				queue.offer(current.left);
				cols.offer(col - 1);
			}
			if (current.right != null) {
				queue.offer(current.right);
				cols.offer(col + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			result.add(map.get(i));
		}
		return result;
	}
}
