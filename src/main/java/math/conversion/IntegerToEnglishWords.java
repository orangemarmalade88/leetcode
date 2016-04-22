package math.conversion;

/*

 Convert a non-negative integer to its english words representation.
 Given input is guaranteed to be less than 2^31 - 1.

 For example,

 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 */

public class IntegerToEnglishWords {

	private final String[] ones = { "", "One", "Two", "Three", "Four", "Five",
			"Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
			"Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
			"Eighteen", "Nineteen" };
	private final String[] tens = { "", "Ten", "Twenty", "Thirty", "Forty",
			"Fifty", "Sixty", "Seventy", "Eighty", "Ninety" };
	private final String[] thousands = { "", "Thousand", "Million", "Billion" };

	public String numberToWords(int num) {
		if (num == 0)
			return "Zero";

		StringBuilder sb = new StringBuilder();

		int t = 0;
		while (num > 0) {
			int mod = num % 1000;
			if (mod > 0)
				sb.insert(0, thousands[t] + " ").insert(0, helper(mod));
			t++;
			num = num / 1000;
		}
		return sb.toString().trim();
	}

	private String helper(int num) {
		StringBuilder sb = new StringBuilder();
		int h = num / 100;
		num = num % 100;
		if (h > 0) {
			sb.append(ones[h]).append(" Hundred ");
		}
		int t = num / 10;
		if (num > 0) {
			if (t < 2) {
				sb.append(ones[num]).append(" ");
			} else {
				num = num % 10;
				sb.append(tens[t]).append(" ");
				if (num > 0) {
					sb.append(ones[num]).append(" ");
				}
			}
		}
		return sb.toString();
	}

	public class Old {

		private String cleanUp(String s) {
			s = s.trim();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				if (i > 0 && s.charAt(i) == ' ' && s.charAt(i - 1) == ' ') {
					continue;
				} else {
					sb.append(s.charAt(i));
				}
			}
			return sb.toString();
		}

		public String numberToWords(int num) {
			if (num == 0)
				return "Zero";
			StringBuffer sb = new StringBuffer();
			int billions = num / 1000000000;
			int mod = num % 1000000000;
			if (billions > 0) {
				sb.append(lessThanThousandNumberToWords(billions)).append(" ")
						.append("Billion").append(" ");
			}
			if (mod > 0)
				sb.append(lessThanBillionNumberToWords(mod)).append(" ");
			return cleanUp(sb.toString());
		}

		private String lessThanBillionNumberToWords(int num) {
			StringBuffer sb = new StringBuffer();
			int millions = num / 1000000;
			int mod = num % 1000000;
			if (millions > 0) {
				sb.append(lessThanThousandNumberToWords(millions)).append(" ")
						.append("Million").append(" ");
			}
			if (mod > 0)
				sb.append(lessThanMillionNumberToWords(mod)).append(" ");
			return sb.toString();
		}

		private String lessThanMillionNumberToWords(int num) {
			StringBuffer sb = new StringBuffer();
			int thousands = num / 1000;
			int mod = num % 1000;
			if (thousands > 0) {
				sb.append(lessThanThousandNumberToWords(thousands)).append(" ")
						.append("Thousand").append(" ");
			}
			if (mod > 0)
				sb.append(lessThanThousandNumberToWords(mod)).append(" ");
			return sb.toString();
		}

		private String lessThanThousandNumberToWords(int num) {
			StringBuffer sb = new StringBuffer();
			int hundreds = num / 100;
			int mod = num % 100;
			if (hundreds > 0) {
				sb.append(lessThanTenNumberToWords(hundreds)).append(" ")
						.append("Hundred").append(" ");
			}
			if (mod > 0)
				sb.append(lessThanHundredNumberToWords(mod)).append(" ");
			return sb.toString();
		}

		private String lessThanHundredNumberToWords(int num) {
			StringBuffer sb = new StringBuffer();
			int tens = num / 10;
			int mod = num % 10;
			if (tens > 0) {
				if (tens == 1) {
					switch (num) {
						case 10:
							return "Ten";
						case 11:
							return "Eleven";
						case 12:
							return "Twelve";
						case 13:
							return "Thirteen";
						case 14:
							return "Fourteen";
						case 15:
							return "Fifteen";
						case 16:
							return "Sixteen";
						case 17:
							return "Seventeen";
						case 18:
							return "Eighteen";
						case 19:
							return "Nineteen";
					}
				} else {
					sb.append(tensToWords(tens)).append(" ");
				}
			}
			if (mod > 0)
				sb.append(lessThanTenNumberToWords(mod)).append(" ");
			return sb.toString();
		}

		private String tensToWords(int tens) {
			switch (tens) {
				case 2:
					return "Twenty";
				case 3:
					return "Thirty";
				case 4:
					return "Forty";
				case 5:
					return "Fifty";
				case 6:
					return "Sixty";
				case 7:
					return "Seventy";
				case 8:
					return "Eighty";
				case 9:
					return "Ninety";
			}
			return null;
		}

		private String lessThanTenNumberToWords(int num) {
			switch (num) {
				case 1:
					return "One";
				case 2:
					return "Two";
				case 3:
					return "Three";
				case 4:
					return "Four";
				case 5:
					return "Five";
				case 6:
					return "Six";
				case 7:
					return "Seven";
				case 8:
					return "Eight";
				case 9:
					return "Nine";
			}
			return null;
		}
	}
}
