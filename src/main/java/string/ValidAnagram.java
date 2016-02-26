package string;

import java.util.Arrays;

/*

 Given two strings s and t, write a function to determine if t is an anagram of s.

 For example,
 s = "anagram", t = "nagaram", return true.
 s = "rat", t = "car", return false.

 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?

 */

public class ValidAnagram {
	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length())
			return false;
		char[] sc = s.toCharArray();
		Arrays.sort(sc);
		String sr = new String(sc);

		char[] tc = t.toCharArray();
		Arrays.sort(tc);
		String tr = new String(tc);

		return sr.equals(tr);
	}

	public boolean isAnagram2(String s, String t) {
		if (s.length() != t.length())
			return false;
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		for (int i = 0; i < t.length(); i++) {
			count[t.charAt(i) - 'a']--;
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] != 0)
				return false;
		}

		return true;
	}
}
