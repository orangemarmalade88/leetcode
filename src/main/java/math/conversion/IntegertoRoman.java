package math.conversion;

/*

 Given an integer, convert it to a roman numeral.

 Input is guaranteed to be within the range from 1 to 3999.

 */

public class IntegertoRoman {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		String[] strs = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X",
				"IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}
}
