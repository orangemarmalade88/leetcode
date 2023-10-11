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
		if (root == null)
			return result;

		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		q1.offer(root);
		q2.offer(0);

		int min = 0;
		int max = 0;

		Map<Integer, List<Integer>> map = new HashMap<>();

		while (!q1.isEmpty()) {
			TreeNode cur = q1.poll();
			int index = q2.poll();

			map.putIfAbsent(index, new ArrayList<>());

			map.get(index).add(cur.val);

			if (cur.left != null) {
				q1.offer(cur.left);
				q2.offer(index - 1);
				min = Math.min(min, index - 1);
			}

			if (cur.right != null) {
				q1.offer(cur.right);
				q2.offer(index + 1);
				max = Math.max(max, index + 1);
			}
		}

		for (int i = min; i <= max; i++) {
			result.add(map.get(i));
		}

		return result;
	}
}
