package string;

public class ValidWordAbbreviation {
	public boolean validWordAbbreviation(String word, String abbr) {
		int i = 0;
		int j = 0;

		while (i < word.length() && j < abbr.length()) {
			if (word.charAt(i) == abbr.charAt(j)) {
				i++;
				j++;
				continue;
			}
			if (Character.isDigit(abbr.charAt(j))) {
				int num = 0;
				char start = abbr.charAt(j);
				while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
					num = num * 10 + abbr.charAt(j) - '0';
					j++;
				}
				if (start == '0')
					return false;

				if (i + num > word.length()) {
					return false;
				}

				i += num;
			} else {
				return false;
			}
		}
		return i == word.length() && j == abbr.length();

	}
}
