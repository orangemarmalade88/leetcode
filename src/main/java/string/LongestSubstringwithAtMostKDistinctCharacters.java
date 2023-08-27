package string;

public class LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		int fast = 0;
		int slow = 0;
		int count = 0;
		int[] dict = new int[256];

		int longest = 0;
		int n = s.length();
		while (fast < n) {
			if (count <= k) {
				char c = s.charAt(fast);
				if (dict[c] == 0)
					count++;
				dict[c]++;
				fast++;
			}
			while (count > k) {
				char c = s.charAt(slow);
				if (dict[c] == 1)
					count--;
				dict[c]--;
				slow++;
			}

			if (fast - slow > longest)
				longest = fast - slow;
		}
		return longest;
	}
}
