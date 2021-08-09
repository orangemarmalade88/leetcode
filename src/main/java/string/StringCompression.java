package string;

public class StringCompression {
	public int compress(char[] chars) {
		int slow = 0;
		int fast = 0;
		int count = 0;
		char cur = chars[0];
		while (fast < chars.length) {
			if (chars[fast] == cur) {
				fast++;
				count++;
			} else {
				chars[slow++] = cur;
				if (count > 1) {
					String s = String.valueOf(count);
					for (int i = 0; i < s.length(); i++) {
						chars[slow++] = s.charAt(i);
					}
				}
				count = 0;
				cur = chars[fast];
			}
		}
		chars[slow++] = cur;
		if (count > 1) {
			String s = String.valueOf(count);
			for (int i = 0; i < s.length(); i++) {
				chars[slow++] = s.charAt(i);
			}
		}
		return slow;
	}
}
