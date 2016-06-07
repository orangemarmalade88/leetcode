package string;

/*

 Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"


 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 */

public class MinimumWindowSubstring {
	public String minWindow(String s, String t) {
		int[] table = new int[256];
		for (char c : t.toCharArray()) {
			table[c]++;
		}
		int count = t.length();
		int begin = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;
		int min_start = -1;
		while (end < s.length()) {
			if (table[s.charAt(end++)]-- > 0) {
				count--;
			}
			while (count == 0) {
				if (end - begin < min) {
					min = end - begin;
					min_start = begin;
				}
				if (table[s.charAt(begin++)]++ == 0)
					count++;
			}
		}
		return min == Integer.MAX_VALUE ? "" : s.substring(min_start, min_start
				+ min);
	}
}
