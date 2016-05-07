package string.longestsubstring;

/*

 Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = "eceba",

 T is "ece" which its length is 3.

 */

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
