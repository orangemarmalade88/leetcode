package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VerifyAnAlienDictionary {
	/*
	 * 953. Verifying an Alien Dictionary
	 *
	 * In an alien language, surprisingly they also use english lowercase
	 * letters, but possibly in a different order. The order of the alphabet is
	 * some permutation of lowercase letters.
	 *
	 * Given a sequence of words written in the alien language, and the order of
	 * the alphabet, return true if and only if the given words are sorted
	 * lexicographicaly in this alien language.
	 *
	 *
	 */
	static Map<Character, Integer> map;

	static class Alien implements Comparator<String> {
		@Override
		public int compare(String s1, String s2) {
			int l = Math.min(s1.length(), s2.length());
			for (int i = 0; i < l; i++) {
				if (map.get(s1.charAt(i)) < map.get(s2.charAt(i)))
					return -1;
				else if (map.get(s1.charAt(i)) > map.get(s2.charAt(i)))
					return 1;
			}
			if (s1.length() < s2.length())
				return -1;
			else if (s1.length() > s2.length())
				return 1;
			return 0;
		}

	}

	public static boolean isAlienSorted(String[] words, String order) {
		map = new HashMap<>();
		for (int i = 0; i < order.length(); i++) {
			map.put(order.charAt(i), i);
		}
		List<String> w = Arrays.asList(words);
		List<String> sorted = new ArrayList<>(w);
		Collections.sort(sorted, new Alien());
		for (int i = 0; i < w.size(); i++) {
			if (w.get(i) != sorted.get(i))
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] words = { "word", "world", "row" };
		String order = "worldabcefghijkmnpqstuvxyz";
		isAlienSorted(words, order);
	}
}
