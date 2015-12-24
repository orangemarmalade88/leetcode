package string;

/*

 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 (you may want to display this pattern in a fixed font for better legibility)

 P   A   H   N
 A P L S I I G
 Y   I   R

 And then read line by line: "PAHNAPLSIIGYIR"

 Write the code that will take a string and make this conversion given a number of rows:
 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

 */

public class ZigZagConversion {
	public String convert(String s, int numRows) {

		// Mistake didn't consider n = 1
		if (numRows == 1)
			return s;

		StringBuilder sb = new StringBuilder();
		int l = s.length();
		int step = 2 * numRows - 2;
		for (int start = 0; start < numRows; start++) {
			int i = start;
			int m_step = step - i * 2;
			while (i < l) {
				sb.append(s.charAt(i));
				if (m_step != 0 && m_step != step && i + m_step < l)
					sb.append(s.charAt(i + m_step));
				i += step;
			}
		}
		return sb.toString();
	}
}
