package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveAllAdjacentDuplicatesinStringII {
	public String removeDuplicates(String s, int k) {
		Deque<int[]> stack = new ArrayDeque<>();
		for (char c : s.toCharArray()) {
			if (stack.isEmpty() || stack.peek()[0] != c) {
				stack.push(new int[] { c, 1 });
			} else {
				int[] top = stack.pop();
				if (top[1] < k - 1) {
					stack.push(new int[] { c, top[1] + 1 });
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			int[] e = stack.pollLast();
			for (int i = 0; i < e[1]; i++) {
				sb.append((char) (e[0]));
			}
		}
		return sb.toString();
	}
}
