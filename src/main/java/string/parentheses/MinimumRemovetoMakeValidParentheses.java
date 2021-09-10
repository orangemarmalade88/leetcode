package string.parentheses;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MinimumRemovetoMakeValidParentheses {
	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		Deque<Integer> stack = new LinkedList<>();
		Set<Integer> toDelete = new HashSet<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '(') {
				count++;
				stack.push(i);
			} else if (c == ')') {
				count--;
				if (count < 0) {
					toDelete.add(i);
					count++;
				}
			}
		}
		while (count > 0) {
			toDelete.add(stack.pop());
			count--;
		}
		for (int i = 0; i < s.length(); i++) {
			if (!toDelete.contains(i)) {
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}

}
