package math;

public class BasicCalculatorII {
	public int calculate(String s) {
		int result = 0;
		int cur_num = 0;
		int last_num = 0;
		char last_op = '+';
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				cur_num = cur_num * 10 + c - '0';
			} else if (c == ' ') {
				continue;
			} else {

				if (last_op == '*') {
					last_num = last_num * cur_num;
				}
				if (last_op == '/') {
					last_num = last_num / cur_num;
				}
				if (last_op == '+' || last_op == '-') {
					result += last_num;
					last_num = last_op == '+' ? cur_num : -cur_num;
				}

				last_op = c;
				cur_num = 0;
			}
		}

		if (last_op == '*') {
			last_num = last_num * cur_num;
		}
		if (last_op == '/') {
			last_num = last_num / cur_num;
		}
		if (last_op == '+') {
			last_num = last_num + cur_num;
		}
		if (last_op == '-') {
			last_num = last_num - cur_num;
		}

		result += last_num;
		return result;
	}
}
