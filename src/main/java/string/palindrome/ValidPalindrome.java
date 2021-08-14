package string.palindrome;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int slow = 0;
		int fast = s.length() - 1;
		while (slow < fast) {
			while (slow < s.length() - 1
					&& !Character.isLetterOrDigit(s.charAt(slow)))
				slow++;
			while (fast >= 0 && !Character.isLetterOrDigit(s.charAt(fast)))
				fast--;
			if (slow >= s.length() - 1)
				return true;
			if (Character.toLowerCase(s.charAt(slow)) != Character
					.toLowerCase(s.charAt(fast)))
				return false;
			slow++;
			fast--;
		}
		return true;
	}
}
