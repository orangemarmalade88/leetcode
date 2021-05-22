package string;

public class ValidPalindrome {
	/*
	 * Given a string s, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 *
	 */
	public boolean isPalindrome(String s) {
		int front = 0;
		int back = s.length() - 1;
		while (front < back) {
			while (front < back && !Character.isLetterOrDigit(s.charAt(front)))
				front++;
			while (front < back && !Character.isLetterOrDigit(s.charAt(back)))
				back--;
			if (Character.toLowerCase(s.charAt(front)) != Character
					.toLowerCase(s.charAt(back))) {
				return false;
			}
			front++;
			back--;
		}
		return true;
	}
}
