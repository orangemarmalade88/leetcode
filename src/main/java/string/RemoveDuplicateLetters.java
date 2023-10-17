package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		Deque<Character> stack = new ArrayDeque<>();
		int[] last_seen_pos = new int[26];
		for (int i = 0; i < s.length(); i++) {
			last_seen_pos[s.charAt(i) - 'a'] = i;
		}

		boolean[] in_stack = new boolean[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			// Remove all elements in stacks if possible
			// if a char is the last one, we must keep it
			// if a char is smaller than current one, we must keep it
			if (!in_stack[c - 'a']) {

				while (!stack.isEmpty() && last_seen_pos[stack.peek() - 'a'] > i
						&& c < stack.peek()) {
					in_stack[stack.pop() - 'a'] = false;
				}
				stack.push(c);
				in_stack[c - 'a'] = true;
			}

		}

		StringBuilder sb = new StringBuilder();
		while (!stack.isEmpty()) {
			sb.append(stack.pollLast());
		}
		return sb.toString();
	}
}
