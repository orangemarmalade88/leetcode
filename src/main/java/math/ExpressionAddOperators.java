package math;

import java.util.ArrayList;
import java.util.List;

/*

 Given a string that contains only digits 0-9 and a target value, return all possibilities
 to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

 Examples:

 "123", 6 -> ["1+2+3", "1*2*3"]
 "232", 8 -> ["2*3+2", "2+3*2"]
 "105", 5 -> ["1*0+5","10-5"]
 "00", 0 -> ["0+0", "0-0", "0*0"]
 "3456237490", 9191 -> []

 */

public class ExpressionAddOperators {

	// Mistake: Always consider cases like 05 06, is it valid?

	// Key point: always reuse the variables/memory in backtracking! saves 50%
	// time

	public List<String> addOperators(String num, int target) {
		List<String> result = new ArrayList<>();
		dfs(num, new StringBuilder(), 0, 0, 0, target, result);
		return result;
	}

	private void dfs(String num, StringBuilder expression, int startIdx,
			long current, long multiplier, int target, List<String> result) {
		if (startIdx == num.length()) {
			if (current == target)
				result.add(new StringBuilder(expression).deleteCharAt(0)
						.toString());
		} else {
			for (int endIdx = startIdx + 1; endIdx <= num.length(); endIdx++) {
				if (num.charAt(startIdx) == '0' && endIdx - startIdx != 1)
					continue;
				long operend = Long.valueOf(num.substring(startIdx, endIdx));

				int len = expression.length();
				dfs(num, expression.append("+").append(operend), endIdx,
						current + operend, operend, target, result);
				expression.setLength(len);
				if (startIdx > 0) {
					dfs(num, expression.append("-").append(operend), endIdx,
							current - operend, -operend, target, result);
					expression.setLength(len);
					// Careful minus sign here
					dfs(num, expression.append("*").append(operend), endIdx,
							current - multiplier + multiplier * operend,
							multiplier * operend, target, result);
					expression.setLength(len);
				}
			}
		}
	}
}
