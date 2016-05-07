package string.longestsubstring;

/*

 Given a string, find the length of the longest substring T that contains at most k distinct characters.

 For example, Given s = "eceba" and k = 2,

 T is "ece" which its length is 3.

 */

public class LongestSubstringWithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int[] table = new int[128];
		int count = 0;
		int begin = 0;
		int end = 0;
		int maxLen = 0;
		while (end < s.length()) {
			if (table[s.charAt(end++)]++ == 0)
				count++;
			while (count > k) {
				if (table[s.charAt(begin++)]-- == 1)
					count--;
			}
			if (end - begin > maxLen)
				maxLen = end - begin;
		}
		return maxLen;
	}
}
