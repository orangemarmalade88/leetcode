package string.palindrome;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
		int[] count = new int[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']++;
		}

		int odds = 0;
		for (int i = 0; i < 26; i++) {
			if (count[i] % 2 == 1)
				odds++;
		}
		return odds <= 1;
	}
}
