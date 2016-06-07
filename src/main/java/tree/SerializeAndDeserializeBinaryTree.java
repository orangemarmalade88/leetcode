package tree;

import java.util.Stack;

import model.TreeNode;

public class SerializeAndDeserializeBinaryTree {
	public class Codec {

		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			if (root == null)
				return "";
			StringBuilder sb = new StringBuilder();
			sb.append(root.val).append(" ");
			sb.append(serialize(root.left)).append(" ");
			sb.append(serialize(root.right)).append(" ");
			sb.append(") ");
			return sb.toString();
		}

		// Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if (data.isEmpty())
				return null;

			Stack<TreeNode> uncompleted = new Stack<>();
			TreeNode root = null;
			String parts[] = data.split(" ");

			int ptr = 0;

			for (String s : parts) {
				if (s.equals(")")) {
					root = uncompleted.pop();
				} else {
					TreeNode node = new TreeNode(Integer.valueOf(s));
					if (!uncompleted.isEmpty()) {
						TreeNode parent = uncompleted.peek();
						if (parent.left == null)
							parent.left = node;
						else
							parent.right = node;
					}
					uncompleted.push(node);
				}
			}

			return root;
		}
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBinaryTree.Codec c = new SerializeAndDeserializeBinaryTree().new Codec();
		TreeNode n = new TreeNode(5);
		n.right = new TreeNode(2);
		String s = c.serialize(n);
		System.out.println(s);
		c.deserialize(s);
	}
}
