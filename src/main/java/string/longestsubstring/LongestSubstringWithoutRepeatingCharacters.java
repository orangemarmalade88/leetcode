package string.longestsubstring;

/*

 Given a string, find the length of the longest substring without repeating characters.
 For example,
 the longest substring without repeating letters for "abcabcbb" is "abc",  which the length is 3.
 For "bbbbb" the longest substring is "b", with the length of 1.

 */

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		boolean[] table = new boolean[256];
		int start = 0, end = 0;
		int max_length = 0;
		while (end < s.length()) {
			char char_end = s.charAt(end);
			char char_start = s.charAt(start);
			if (table[char_end]) {
				table[char_start] = false;
				start++;
			} else {
				table[char_end] = true;
				end++;
				if (end - start > max_length)
					max_length = end - start;
			}
		}
		return max_length;
	}
}
