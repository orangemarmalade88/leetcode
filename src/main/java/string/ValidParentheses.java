package string;

import java.util.Deque;
import java.util.LinkedList;

public class ValidParentheses {
	public boolean isValid(String s) {
		Deque<Character> stack = new LinkedList<>();
		for (char c : s.toCharArray()) {
			if (c == '[' || c == '(' || c == '{')
				stack.push(c);
			else {
				if (stack.isEmpty())
					return false;
				char counter = stack.pop();
				if (counter == '[' && c != ']')
					return false;
				if (counter == '{' && c != '}')
					return false;
				if (counter == '(' && c != ')')
					return false;
			}
		}
		return stack.isEmpty();
	}
}
