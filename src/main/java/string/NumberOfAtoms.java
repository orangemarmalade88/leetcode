package string;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

// O(M*N)
public class NumberOfAtoms {
	/*
	 * 726. Number of Atoms
	 *
	 * Given a chemical formula (given as a string), return the count of each
	 * atom.
	 *
	 * The atomic element always starts with an uppercase character, then zero
	 * or more lowercase letters, representing the name.
	 *
	 * One or more digits representing that element's count may follow if the
	 * count is greater than 1. If the count is 1, no digits will follow. For
	 * example, H2O and H2O2 are possible, but H1O2 is impossible.
	 *
	 * Two formulas concatenated together to produce another formula. For
	 * example, H2O2He3Mg4 is also a formula.
	 *
	 * A formula placed in parentheses, and a count (optionally added) is also a
	 * formula. For example, (H2O2) and (H2O2)3 are formulas.
	 *
	 * Given a formula, return the count of all elements as a string in the
	 * following form: the first name (in sorted order), followed by its count
	 * (if that count is more than 1), followed by the second name (in sorted
	 * order), followed by its count (if that count is more than 1), and so on.
	 *
	 *
	 */
	public String countOfAtoms(String formula) {
		SortedMap<String, Integer> map = count(formula);
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			sb.append(entry.getKey());
			if (entry.getValue() != 1)
				sb.append(entry.getValue());
		}
		return sb.toString();
	}

	SortedMap<String, Integer> count(String formula) {
		SortedMap<String, Integer> map = new TreeMap<>();
		for (int i = 0; i < formula.length(); i++) {
			if (formula.charAt(i) <= 'Z' && formula.charAt(i) >= 'A') {
				StringBuilder element = new StringBuilder();
				element.append(formula.charAt(i));
				if (i + 1 < formula.length() && formula.charAt(i + 1) <= 'z'
						&& formula.charAt(i + 1) >= 'a') {
					element.append(formula.charAt(i + 1));
					i++;
				}
				StringBuilder num = new StringBuilder();
				while (i + 1 < formula.length() && formula.charAt(i + 1) <= '9'
						&& formula.charAt(i + 1) >= '0') {
					num.append(formula.charAt(i + 1));
					i++;
				}
				int number;
				if (num.length() == 0) {
					number = 1;
				} else {
					number = Integer.parseInt(num.toString());
				}
				int current_count = map.getOrDefault(element.toString(), 0);
				map.put(element.toString(), current_count + number);
			} else if (formula.charAt(i) == '(') {
				int start_index = ++i;
				int bracket_count = 1;
				while (bracket_count > 0) {
					if (formula.charAt(i) == '(')
						bracket_count++;
					else if (formula.charAt(i) == ')')
						bracket_count--;
					i++;
				}
				int end_index = --i;
				SortedMap<String, Integer> sub_map = count(
						formula.substring(start_index, end_index));
				StringBuilder num = new StringBuilder();
				while (i + 1 < formula.length() && formula.charAt(i + 1) <= '9'
						&& formula.charAt(i + 1) >= '0') {
					num.append(formula.charAt(i + 1));
					i++;
				}
				int number;
				if (num.length() == 0) {
					number = 1;
				} else {
					number = Integer.parseInt(num.toString());
				}
				for (Map.Entry<String, Integer> entry : sub_map.entrySet()) {
					int current_count = map.getOrDefault(entry.getKey(), 0);
					map.put(entry.getKey(),
							current_count + number * entry.getValue());
				}
			}
		}
		return map;
	}

	public static void main(String[] args) {
		NumberOfAtoms n = new NumberOfAtoms();
		int i = 0;
		try {
			i = Integer.parseInt("5");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		if (i > 0)
			System.out.println(n.countOfAtoms("((HHe28Be26He)9)34"));
	}
}
