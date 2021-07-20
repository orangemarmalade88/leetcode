package string;

import java.util.HashSet;
import java.util.Set;

public class MinimumDeletionsToMakeCharacterFrequenciesUnique {
	/*
	 * A string s is called good if there are no two different characters in s
	 * that have the same frequency.
	 * 
	 * Given a string s, return the minimum number of characters you need to
	 * delete to make s good.
	 * 
	 * The frequency of a character in a string is the number of times it
	 * appears in the string. For example, in the string "aab", the frequency of
	 * 'a' is 2, while the frequency of 'b' is 1.
	 * 
	 * 
	 */
	public int minDeletions(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}
		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] > 0) {
				if (!set.contains(count[i]))
					set.add(count[i]);
				else {
					int n = count[i];
					while (set.contains(n) && n > 0) {
						res++;
						n--;
					}
					set.add(n);
				}
			}
		}
		return res;
	}
}
