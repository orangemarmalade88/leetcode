package string;

import java.util.HashMap;
import java.util.Map;

/*

 An abbreviation of a word follows the form <first letter><number><last letter>.
 Below are some examples of word abbreviations:

 a) it                      --> it    (no abbreviation)

 1
 b) d|o|g                   --> d1g

 1    1  1
 1---5----0----5--8
 c) i|nternationalizatio|n  --> i18n

 1
 1---5----0
 d) l|ocalizatio|n          --> l10n
 Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. .
 A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.

 Example:
 Given dictionary = [ "deer", "door", "cake", "card" ]

 isUnique("dear") -> false
 isUnique("cart") -> true
 isUnique("cane") -> false
 isUnique("make") -> true

 */

public class UniqueWordAbbreviation {
	public class ValidWordAbbr {

		Map<String, String> map = new HashMap<>();

		private String abbre(String word) {
			if (word.length() <= 2)
				return word;
			StringBuilder sb = new StringBuilder();
			sb.append(word.charAt(0)).append(word.length() - 2)
					.append(word.charAt(word.length() - 1));
			return sb.toString();
		}

		public ValidWordAbbr(String[] dictionary) {
			for (String s : dictionary) {
				String abbre = abbre(s);
				if (map.containsKey(abbre)) {
					if (!s.equals(map.get(abbre))) {
						map.put(abbre, null);
					}
				} else {
					map.put(abbre, s);
				}
			}
		}

		public boolean isUnique(String word) {
			String abbre = abbre(word);
			if (map.containsKey(abbre)) {
				return word.equals(map.get(abbre));
			}
			return true;
		}
	}

}
