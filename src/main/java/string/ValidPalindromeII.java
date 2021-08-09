package string;

public class ValidPalindromeII {
	public boolean validPalindrome(String s) {
		int slow = 0;
		int fast = s.length() - 1;
		while (slow < fast) {
			if (s.charAt(slow) == s.charAt(fast)) {
				slow++;
				fast--;
			} else {
				return isPalindrome(s, slow + 1, fast)
						|| isPalindrome(s, slow, fast - 1);
			}
		}
		return true;
	}

	public boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}
