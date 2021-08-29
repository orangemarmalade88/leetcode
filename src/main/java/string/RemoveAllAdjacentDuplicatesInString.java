package string;

import java.util.Deque;
import java.util.LinkedList;

public class RemoveAllAdjacentDuplicatesInString {
	public String removeDuplicates(String s) {
		Deque<Character> stack = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			} else {
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		return sb.toString();
	}
}
