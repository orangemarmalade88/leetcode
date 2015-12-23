package string;

import java.util.Stack;

/*

 Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 determine if the input string is valid.

 The brackets must close in the correct order,
 "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

 */

public class ValidParentheses {
	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			switch (c) {
				case ')':
					if (stack.isEmpty() || stack.pop() != '(')
						return false;
					continue;
				case '}':
					if (stack.isEmpty() || stack.pop() != '(')
						return false;
					continue;
				case ']':
					if (stack.isEmpty() || stack.pop() != '(')
						return false;
					continue;
				default:
					stack.push(c);
			}
		}
		// Mistake: Forgot to check if stack is empty
		return stack.isEmpty();
	}
}
