package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class AnalyzeUserWebsiteVisitPattern {
	class Pattern {
		String username;
		int time;
		String website;

		Pattern(String u, int t, String w) {
			username = u;
			time = t;
			website = w;
		}
	}

	public List<String> mostVisitedPattern(String[] username, int[] timestamp,
			String[] website) {
		Map<String, List<String>> map = new HashMap<>();
		Map<String, Integer> counts = new HashMap<>();
		int max = 0;
		String m = "";
		List<Pattern> ps = new ArrayList<>();
		for (int i = 0; i < username.length; i++) {
			Pattern p = new Pattern(username[i], timestamp[i], website[i]);
			ps.add(p);
		}
		Collections.sort(ps, (a, b) -> a.time - b.time);

		for (Pattern p : ps) {
			if (!map.containsKey(p.username)) {
				map.put(p.username, new ArrayList<>());
			}
			map.get(p.username).add(p.website);
		}

		for (String u : map.keySet()) {
			Set<String> set = new HashSet<>();
			List<String> webs = map.get(u);
			for (int i = 0; i < webs.size(); i++) {
				for (int j = i + 1; j < webs.size(); j++) {
					for (int k = j + 1; k < webs.size(); k++) {
						String all = webs.get(i) + "+" + webs.get(j) + "+"
								+ webs.get(k);
						if (!set.contains(all)) {
							set.add(all);
							int count = counts.getOrDefault(all, 0) + 1;
							counts.put(all, count);
							if (count > max) {
								max = count;
								m = all;
							} else if (count == max) {
								if (all.compareTo(m) < 0)
									m = all;
							}
						}
					}
				}
			}
		}

		List<String> res = new ArrayList<>();
		for (String ss : m.split("\\+")) {
			res.add(ss);
		}

		return res;
	}

	public static void main(String[] args) {
		String[] usernames = { "h", "eiy", "cq", "h", "cq", "txldsscx", "cq",
				"txldsscx", "h", "cq", "cq" };
		int[] timestamps = { 527896567, 334462937, 517687281, 134127993,
				859112386, 159548699, 51100299, 444082139, 926837079, 317455832,
				411747930 };
		String[] patterns = { "hibympufi", "hibympufi", "hibympufi",
				"hibympufi", "hibympufi", "hibympufi", "hibympufi", "hibympufi",
				"yljmntrclw", "hibympufi", "yljmntrclw" };
		AnalyzeUserWebsiteVisitPattern a = new AnalyzeUserWebsiteVisitPattern();
		a.mostVisitedPattern(usernames, timestamps, patterns);

	}
}
