package interval;

public class RangeSumQueryMutable {
	public class NumArray {

		public class TreeNode {
			public int val;
			public TreeNode left;
			public TreeNode right;

			public TreeNode(int x) {
				val = x;
			}
		}

		TreeNode root = null;
		int[] nums;

		private TreeNode makeTree(int[] nums, int start, int end) {
			if (start > end)
				return null;
			if (start == end)
				return new TreeNode(nums[start]);
			int mid = (start + end) >>> 1;
			TreeNode left = makeTree(nums, start, mid);
			TreeNode right = makeTree(nums, mid + 1, end);
			int sum = (left == null ? 0 : left.val)
					+ (right == null ? 0 : right.val);
			TreeNode root = new TreeNode(sum);
			root.left = left;
			root.right = right;
			return root;
		}

		private void updateTree(TreeNode root, int diff, int i, int start,
				int end) {
			if (start > end)
				return;
			root.val += diff;
			if (start == end)
				return;
			int mid = (start + end) >>> 1;
			if (i <= mid)
				updateTree(root.left, diff, i, start, mid);
			else
				updateTree(root.right, diff, i, mid + 1, end);
		}

		private int sumRange(TreeNode root, int i, int j, int start, int end) {
			if (i == start && j == end) {
				return root.val;
			} else {
				int mid = (start + end) >>> 1;
				if (j <= mid) {
					return sumRange(root.left, i, j, start, mid);
				} else if (i >= mid + 1) {
					return sumRange(root.right, i, j, mid + 1, end);
				} else {
					return sumRange(root.left, i, mid, start, mid)
							+ sumRange(root.right, mid + 1, j, mid + 1, end);
				}
			}
		}

		public NumArray(int[] nums) {
			root = makeTree(nums, 0, nums.length - 1);
			this.nums = nums;
		}

		void update(int i, int val) {
			int diff = val - nums[i];
			nums[i] = val;
			updateTree(root, diff, i, 0, nums.length - 1);
		}

		public int sumRange(int i, int j) {
			return sumRange(root, i, j, 0, nums.length - 1);
		}
	}
}
