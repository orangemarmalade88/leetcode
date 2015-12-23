package string;

/*

 Write a function to find the longest common prefix string amongst an array of strings.

 */

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		int end = 0;
		if (strs == null || strs.length == 0)
			return "";
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			boolean same = true;
			for (int n = 1; n < strs.length; n++) {
				if (i < strs[n].length() && strs[n].charAt(i) == c)
					continue;
				else
					same = false;
			}
			if (same)
				end++;
			else
				break;

		}
		if (end == 0)
			return "";
		else
			return strs[0].substring(0, end);
	}

	// Improvement1: "String".substring(0, 0) is OK
	// Improvement2: use i as end
	// Improvement3: just return strs[0]
	public String longestCommonPrefix2(String[] strs) {
		int i = 0;
		if (strs == null || strs.length == 0)
			return "";
		for (i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int n = 1; n < strs.length; n++) {
				if (i >= strs[n].length() || strs[n].charAt(i) != c)
					return strs[0].substring(0, i);
			}
		}
		return strs[0];
	}
}
