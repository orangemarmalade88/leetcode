package string;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 1)
			return strs[0];
		String cur = strs[0];
		for (int i = 1; i < strs.length; i++) {
			cur = longestCommonPrefix(cur, strs[i]);
		}
		return cur;
	}

	public String longestCommonPrefix(String a, String b) {
		int i = 0;
		while (i < a.length() && i < b.length()) {
			if (a.charAt(i) != b.charAt(i)) {
				break;
			}
			i++;
		}
		return a.substring(0, i);
	}
}
