package string;

import java.util.ArrayList;
import java.util.List;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word) {
		List<String> result = new ArrayList<>();
		dfs(word, true, 0, "", result);
		return result;
	}

	private void dfs(String word, boolean canAbbre, int startIdx,
			String current, List<String> result) {
		if (startIdx == word.length())
			result.add(current);
		else {
			dfs(word, true, startIdx + 1, current + word.charAt(startIdx),
					result);
			if (canAbbre) {
				for (int l = 1; l + startIdx <= word.length(); l++) {
					dfs(word, false, startIdx + l, current + l, result);
				}
			}
		}
	}
}
