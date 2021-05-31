package math;

import java.util.ArrayList;
import java.util.List;

public class CompareVersionNumbers {
	/*
	 * Given two version numbers, version1 and version2, compare them.
	 * 
	 * Version numbers consist of one or more revisions joined by a dot '.'.
	 * Each revision consists of digits and may contain leading zeros. Every
	 * revision contains at least one character. Revisions are 0-indexed from
	 * left to right, with the leftmost revision being revision 0, the next
	 * revision being revision 1, and so on. For example 2.5.33 and 0.1 are
	 * valid version numbers.
	 * 
	 * To compare version numbers, compare their revisions in left-to-right
	 * order. Revisions are compared using their integer value ignoring any
	 * leading zeros. This means that revisions 1 and 001 are considered equal.
	 * If a version number does not specify a revision at an index, then treat
	 * the revision as 0. For example, version 1.0 is less than version 1.1
	 * because their revision 0s are the same, but their revision 1s are 0 and 1
	 * respectively, and 0 < 1.
	 * 
	 * Return the following:
	 * 
	 * If version1 < version2, return -1. If version1 > version2, return 1.
	 * Otherwise, return 0.
	 * 
	 */
	public int compareVersion(String version1, String version2) {

		int i = 0;
		int j = 0;

		List<Integer> v1s = new ArrayList<>();
		List<Integer> v2s = new ArrayList<>();
		parse(version1, v1s);
		parse(version2, v2s);

		while (i < v1s.size() || j < v2s.size()) {
			int vv1 = i < v1s.size() ? v1s.get(i) : 0;
			int vv2 = j < v2s.size() ? v2s.get(j) : 0;
			if (vv1 < vv2) {
				return -1;
			} else if (vv1 > vv2) {
				return 1;
			}
			i++;
			j++;
		}
		return 0;
	}

	public void parse(String v, List<Integer> vs) {
		int i = 0;
		int num = 0;
		while (i < v.length()) {
			if (v.charAt(i) == '.') {
				vs.add(num);
				i++;
				num = 0;
			} else {
				num = num * 10 + v.charAt(i) - '0';
				i++;
			}
		}
		vs.add(num);
	}

	public static void main(String[] args) {
		CompareVersionNumbers c = new CompareVersionNumbers();
		c.compareVersion("1.0.1", "1");
	}
}
