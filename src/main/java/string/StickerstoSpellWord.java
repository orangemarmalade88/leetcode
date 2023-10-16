package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class StickerstoSpellWord {
	public int minStickers(String[] stickers, String target) {
		Map<Character, Integer> t_dict = new HashMap<>();
		for (char c : target.toCharArray()) {
			t_dict.put(c, t_dict.getOrDefault(c, 0) + 1);
		}

		Map<String, Map<Character, Integer>> sticks = new HashMap<>();

		for (String st : stickers) {
			Map<Character, Integer> s_dict = new HashMap<>();
			for (char c : st.toCharArray()) {
				s_dict.put(c, s_dict.getOrDefault(c, 0) + 1);
			}
			sticks.put(st, s_dict);
		}

		List<String> toRemove = new ArrayList<>();
		for (int i = 0; i < stickers.length; i++) {
			for (int j = 0; j < stickers.length; j++) {
				if (i != j) {
					boolean remove = true;
					Map<Character, Integer> si = sticks.get(stickers[i]);
					Map<Character, Integer> sj = sticks.get(stickers[j]);
					for (char c : si.keySet()) {
						if (si.get(c) > sj.getOrDefault(c, 0))
							remove = false;
					}
					if (remove)
						toRemove.add(stickers[i]);
				}
			}
		}
		for (String s : toRemove) {
			sticks.remove(s);
		}

		Queue<Map<Character, Integer>> q = new LinkedList<>();
		q.offer(t_dict);
		int depth = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				Map<Character, Integer> cur = q.poll();
				if (cur.isEmpty())
					return depth;
				for (Map<Character, Integer> ss : sticks.values()) {
					Map<Character, Integer> next = new HashMap<>(cur);
					List<Character> l = new ArrayList<>(next.keySet());
					if (ss.containsKey(l.get(0))) {
						for (char c : l) {
							if (ss.containsKey(c)) {
								if (next.get(c) <= ss.get(c)) {
									next.remove(c);
								} else {
									next.put(c, next.get(c) - ss.get(c));
								}
							}
						}

						q.offer(next);
					}
				}
			}
			depth++;
		}
		return -1;
	}
}
