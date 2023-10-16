package tree.traversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import model.TreeNode;

public class VerticalOrderTraversalofaBinaryTree {
	public List<List<Integer>> verticalTraversal(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		if (root == null)
			return result;

		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<Integer> q2 = new LinkedList<>();

		q1.offer(root);
		q2.offer(0);

		int min = 0;
		int max = 0;

		Map<Integer, List<int[]>> map = new HashMap<>();

		int depth = 0;

		while (!q1.isEmpty()) {
			int size = q1.size();
			while (size-- > 0) {
				TreeNode cur = q1.poll();
				int index = q2.poll();

				map.putIfAbsent(index, new ArrayList<>());

				map.get(index).add(new int[] { depth, cur.val });

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
			depth++;
		}

		for (int i = min; i <= max; i++) {
			Collections.sort(map.get(i),
					(a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
			List<Integer> col = new ArrayList<>();
			for (int[] s : map.get(i)) {
				col.add(s[1]);
			}
			result.add(col);
		}

		return result;
	}
}
