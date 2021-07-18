package string;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {
	public List<String> removeComments(String[] source) {
		List<String> res = new ArrayList<>();
		StringBuilder partial = new StringBuilder();
		boolean opened = false;
		for (String s : source) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				if (opened) {
					if (c != '*')
						continue;
					else if (i + 1 >= s.length() || s.charAt(i + 1) != '/')
						continue;
					else {
						sb.append(partial.toString());
						partial = new StringBuilder();
						opened = false;
						i++;
					}
				} else {
					if (c != '/' || (c == '/' && i + 1 >= s.length())
							|| (c == '/' && s.charAt(i + 1) != '/'
									&& s.charAt(i + 1) != '*')) {
						sb.append(c);
					} else if (s.charAt(i + 1) == '/') {
						break;
					} else {
						opened = true;
						partial.append(sb.toString());
						sb = new StringBuilder();
						i++;
					}
				}
			}
			String p = sb.toString();
			if (!opened && !p.isEmpty())
				res.add(sb.toString());
		}
		return res;
	}
}
