package string;

import java.util.LinkedList;

public class SimplifyPath {
	public String simplifyPath(String path) {
		String[] parts = path.split("/");
		LinkedList<String> s = new LinkedList<>();
		for (String p : parts) {
			if (p.equals("..")) {
				if (!s.isEmpty())
					s.removeLast();
			} else if (p.equals(".") || p.isEmpty()) {
				continue;
			} else
				s.addLast(p);
		}

		if (s.isEmpty())
			return "/";

		StringBuilder sb = new StringBuilder();

		for (String p : s) {
			sb.append("/");
			sb.append(p);
		}

		return sb.toString();
	}
}
