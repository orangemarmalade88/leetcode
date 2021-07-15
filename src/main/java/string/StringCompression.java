package string;

public class StringCompression {
	/*
	 * Given an array of characters chars, compress it using the following
	 * algorithm:
	 * 
	 * Begin with an empty string s. For each group of consecutive repeating
	 * characters in chars:
	 * 
	 * If the group's length is 1, append the character to s. Otherwise, append
	 * the character followed by the group's length. The compressed string s
	 * should not be returned separately, but instead be stored in the input
	 * character array chars. Note that group lengths that are 10 or longer will
	 * be split into multiple characters in chars.
	 * 
	 * After you are done modifying the input array, return the new length of
	 * the array.
	 * 
	 * You must write an algorithm that uses only constant extra space.
	 * 
	 */
	public int compress(char[] chars) {
		int index = 0;
		char prev = '0';
		int count = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != prev) {
				if (count > 0) {
					chars[index++] = prev;
					if (count > 1) {
						String num = String.valueOf(count);
						for (int j = 0; j < num.length(); j++) {
							chars[index++] = num.charAt(j);
						}
					}
				}
				prev = chars[i];
				count = 1;
			} else {
				count++;
			}
		}

		chars[index++] = prev;
		if (count > 1) {
			String num = String.valueOf(count);
			for (int j = 0; j < num.length(); j++) {
				chars[index++] = num.charAt(j);
			}
		}

		return index;

	}
}
