package array;

import java.util.Arrays;

public class MaximumSwap {
	public int maximumSwap(int num) {

		String s = String.valueOf(num); // original string 2736
		char[] d = s.toCharArray();
		Arrays.sort(d);

		StringBuilder sb2 = new StringBuilder(String.valueOf(d));
		String s2 = sb2.reverse().toString(); // sorted string 7632

		// find first different char, we need to swap s[i] and s2[i] (2 and 7)
		int i = 0;
		while (i < s.length()) {
			if (s.charAt(i) != s2.charAt(i)) {
				break;
			}
			i++;
		}

		if (i == s.length()) // no diff, return
			return num;

		// find the last occurrence of s2[i] 7 in s (2736)
		char toSwap = s2.charAt(i);
		int j = s.length() - 1;
		while (j >= 0) {
			if (s.charAt(j) == toSwap)
				break;
			j--;
		}

		char temp;
		StringBuilder res = new StringBuilder(s);
		temp = s.charAt(i);
		res.setCharAt(i, s.charAt(j));
		res.setCharAt(j, temp);
		return Integer.valueOf(res.toString());

	}
}
