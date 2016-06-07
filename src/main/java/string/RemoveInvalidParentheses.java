package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class RemoveInvalidParentheses {
	public List<String> removeInvalidParentheses(String s) {
		List<String> result = new ArrayList<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> set = new HashSet<>();
		queue.add(s);
		boolean hasResult = false;
		while (!hasResult && !queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String curr = queue.poll();
				if (isValid(curr)) {
					result.add(curr);
					hasResult = true;
				} else if (!hasResult) {
					for (int j = 0; j < curr.length(); j++) {
						StringBuilder sb = new StringBuilder(curr);
						if (sb.charAt(j) == '(' || sb.charAt(j) == ')') {
							sb.deleteCharAt(j);
							if (!set.contains(sb.toString())) {
								queue.add(sb.toString());
								set.add(sb.toString());
							}
						}
					}
				}
			}

		}
		return result;
	}

	private boolean isValid(String s) {
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else if (s.charAt(i) == ')') {
				if (--count < 0)
					return false;
			}
		}
		return count == 0;
	}

	public static void main(String[] args) {
		RemoveInvalidParentheses r = new RemoveInvalidParentheses();
		r.removeInvalidParentheses("()())()");
	}
}
