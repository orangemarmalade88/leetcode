package math.combination;

import java.util.ArrayList;
import java.util.List;

/*

 Given a digit string, return all possible letter combinations that the number could represent.

 A mapping of digit to letters (just like on the telephone buttons) is given below.

 Input:Digit string "23"
 Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].

 Note:
 Although the above answer is in lexicographical order, your answer could be in any order you want.

 */

public class LetterCombinationsofaPhoneNumber {

	String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
			"tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		letterCombinations(digits, "", 0, result);
		return result;
	}

	public void letterCombinations(String digits, String current, int i,
			List<String> result) {
		if (i == digits.length()) {
			if (!current.isEmpty())
				result.add(current);
		} else {
			char c = digits.charAt(i);
			String map = mapping[c - '0'];
			for (int n = 0; n < map.length(); n++) {
				char ch = map.charAt(n);
				letterCombinations(digits, current + ch, i + 1, result);
			}
		}
	}
}
