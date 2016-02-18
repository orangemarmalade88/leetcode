package string.palindrome;

import java.util.BitSet;

/*

 Given a string, determine if a permutation of the string could form a palindrome.

 For example,
 "code" -> False, "aab" -> True, "carerac" -> True.

 */

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		int[] counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i)]++;
		}
		boolean hasOddCount = false;
		for (int j = 0; j < counts.length; j++) {
			if (counts[j] % 2 != 0) {
				if (hasOddCount)
					return false;
				else
					hasOddCount = true;
			}
		}
		return true;
	}

	public boolean canPermutePalindrome2(String s) {
		BitSet bs = new BitSet();
		for (char c : s.toCharArray()) {
			bs.flip(c);
		}
		return bs.cardinality() <= 1;
	}
}
