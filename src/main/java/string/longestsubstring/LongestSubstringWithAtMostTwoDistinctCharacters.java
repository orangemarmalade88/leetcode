package string.longestsubstring;

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		int[] table = new int[128];
		int count = 0;
		int begin = 0;
		int end = 0;
		int maxLen = 0;
		while (end < s.length()) {
			if (table[s.charAt(end++)]++ == 0)
				count++;
			while (count > 2) {
				if (table[s.charAt(begin++)]-- == 1)
					count--;
			}
			if (end - begin > maxLen)
				maxLen = end - begin;
		}
		return maxLen;
	}
}
