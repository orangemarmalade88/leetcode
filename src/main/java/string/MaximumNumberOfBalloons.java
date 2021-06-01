package string;

public class MaximumNumberOfBalloons {
	/*
	 * Given a string text, you want to use the characters of text to form as
	 * many instances of the word "balloon" as possible.
	 * 
	 * You can use each character in text at most once. Return the maximum
	 * number of instances that can be formed.
	 * 
	 * 
	 */
	public int maxNumberOfBalloons(String text) {
		int[] count = new int[26];
		for (int i = 0; i < text.length(); i++) {
			count[text.charAt(i) - 'a']++;
		}
		int res = Integer.MAX_VALUE;
		res = Math.min(res, count['a' - 'a']);
		res = Math.min(res, count['b' - 'a']);

		res = Math.min(res, count['n' - 'a']);

		res = Math.min(res, count['l' - 'a'] / 2);

		res = Math.min(res, count['o' - 'a'] / 2);
		return res;
	}
}
