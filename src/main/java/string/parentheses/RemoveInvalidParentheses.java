package string.parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	public static List<String> removeInvalidParentheses(String s) {
		List<String> res = new ArrayList<>();

		Set<String> set = new HashSet<>();
		Set<String> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();
		q.offer(s);
		visited.add(s);

		boolean found = false;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String cur = q.poll();
				if (isValid(cur)) {
					found = true;
					set.add(cur);
				}
				for (int i = 0; i < cur.length(); i++) {
					StringBuilder sb = new StringBuilder(cur);
					String deleted = sb.deleteCharAt(i).toString();

					if (!visited.contains(deleted)) {
						q.offer(deleted);
						visited.add(deleted);
					}
				}
			}
			if (found) {
				res.addAll(set);
				return res;
			}
		}

		return res;
	}

	public static boolean isValid(String s) {
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == '(') {
				count++;
			} else if (c == ')') {
				count--;
				if (count < 0)
					return false;
			}
		}
		return count == 0;
	}

	public static void main(String[] args) {
		removeInvalidParentheses(")(");
	}
}
