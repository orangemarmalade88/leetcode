package string;

public class ReverseString {
	/*
	 * Write a function that reverses a string. The input string is given as an
	 * array of characters s.
	 * 
	 * 
	 */
	public void reverseString(char[] s) {
		int i = 0;
		int j = s.length - 1;
		while (i < j) {
			char tmp = s[i];
			s[i] = s[j];
			s[j] = tmp;
			i++;
			j--;
		}
	}
}
