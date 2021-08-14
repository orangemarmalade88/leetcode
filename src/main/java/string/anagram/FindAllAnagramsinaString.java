package string.anagram;

import java.util.ArrayList;
import java.util.List;

public class FindAllAnagramsinaString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> l = new ArrayList<>();
		int[] count = new int[26];
		int matched = 0;
		int total = p.length();
		int unique = 0;
		for (char c : p.toCharArray()) {
			if (count[c - 'a'] == 0)
				unique++;
			count[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (count[c - 'a'] == 1)
				matched++;
			if (count[c - 'a'] == 0)
				matched--;
			count[c - 'a']--;
			if (i >= total) {
				char d = s.charAt(i - total);
				if (count[d - 'a'] == -1)
					matched++;
				if (count[d - 'a'] == 0)
					matched--;

				count[d - 'a']++;
			}
			if (matched == unique) {
				l.add(i - total + 1);
			}
		}
		return l;
	}
}
