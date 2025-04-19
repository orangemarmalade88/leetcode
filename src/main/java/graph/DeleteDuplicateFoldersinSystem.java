package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.SortedMap;
import java.util.TreeMap;

public class DeleteDuplicateFoldersinSystem {
	class Folder {
		public Folder(String name) {
			super();
			this.name = name;
		}

		boolean mark_delete = false;
		String name;
		SortedMap<String, Folder> subs = new TreeMap<>();
	}

	Folder root = new Folder("");

	public void buildGraph(List<List<String>> paths,
			Map<Folder, List<String>> map) {
		for (List<String> path : paths) {
			Folder cur = root;

			for (String s : path) {
				if (!cur.subs.containsKey(s)) {
					cur.subs.put(s, new Folder(s));
				}
				cur = cur.subs.get(s);
			}
			map.put(cur, path);
		}
	}

	public String getKey(Folder f) {
		StringBuilder sb = new StringBuilder();
		sb.append(f.name);
		sb.append("{");
		for (String s : f.subs.keySet()) {
			sb.append(getKey(f.subs.get(s))).append(",");
		}
		sb.append("}");
		return sb.toString();
	}

	public void traverse(List<List<String>> result,
			Map<Folder, List<String>> map) {
		Queue<Folder> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			Folder f = q.poll();
			if (!f.mark_delete) {
				if (f != root)
					result.add(map.get(f));
				for (Folder n : f.subs.values()) {
					q.offer(n);
				}
			}
		}
	}

	public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
		Map<Folder, List<String>> map = new HashMap<>();
		Map<String, Integer> count = new HashMap<>();

		buildGraph(paths, map);

		for (Folder f : map.keySet()) {
			String key = getKey(f);
			String child_key = key.substring(key.indexOf('{'));
			count.put(child_key, count.getOrDefault(key, 0) + 1);
		}

		for (Folder f : map.keySet()) {
			String key = getKey(f);
			String child_key = key.substring(key.indexOf('{'));
			if (count.get(child_key) > 1 && !child_key.equals("{}"))
				f.mark_delete = true;
		}

		List<List<String>> result = new ArrayList<>();
		traverse(result, map);

		return result;
	}
}
