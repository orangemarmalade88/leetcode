package string;

public class CustomSortString {
	public String customSortString(String order, String s) {
		int[] dict = new int[26];
		for (char c : s.toCharArray()) {
			dict[c - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		for (char c : order.toCharArray()) {
			for (int i = 0; i < dict[c - 'a']; i++) {
				sb.append(c);
			}
			dict[c - 'a'] = 0;
		}

		for (char c = 'a'; c <= 'z'; c++) {
			for (int j = 0; j < dict[c - 'a']; j++) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
