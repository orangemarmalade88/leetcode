package string;

import java.util.ArrayList;
import java.util.List;

public class ZigZagConversion {
	public String convert(String s, int numRows) {
		if (numRows == 1)
			return s;
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			list.add(new StringBuilder());
		}

		int j = 0;
		while (j < s.length()) {
			for (int i = 0; i < numRows; i++) {
				if (j < s.length()) {
					list.get(i).append(s.charAt(j));
					j++;
				}
			}
			for (int i = numRows - 2; i >= 1; i--) {
				if (j < s.length()) {
					list.get(i).append(s.charAt(j));
					j++;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			sb.append(list.get(i));
		}
		return sb.toString();

	}
}
