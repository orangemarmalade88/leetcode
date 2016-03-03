package math.conversion;

/*

 Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:
 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB

 */

public class ExcelSheetColumnTitle {
	public String convertToTitle(int n) {
		StringBuffer sb = new StringBuffer();
		while (n > 0) {
			int mod = (n - 1) % 26;
			sb.append((char) (mod + 'A'));
			n = (n - 1) / 26;
		}
		return sb.reverse().toString();
	}
}
