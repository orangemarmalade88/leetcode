package math.combination;
import java.util.ArrayList;
import java.util.List;

/*

 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"

 */

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		generateParenthesis("", n, 0, 0, result);
		return result;
	}

	public void generateParenthesis(String s, int n, int left, int right,
			List<String> result) {
		if (left == n && right == n) {
			result.add(s);
		} else {
			if (left < n) {
				generateParenthesis(s + "(", n, left + 1, right, result);
			}
			if (right < left) {
				generateParenthesis(s + ")", n, left, right + 1, result);
			}
		}
	}
}
