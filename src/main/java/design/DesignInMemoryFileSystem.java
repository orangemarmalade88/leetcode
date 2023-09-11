package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DesignInMemoryFileSystem {

	class Data {
		String path;
		List<Data> children = new ArrayList<>();
		String data = "";

		public Data(String path) {
			super();
			this.path = path;
		}

	}

	Map<String, Data> map = new HashMap<>();

	public DesignInMemoryFileSystem() {
		mkdir("");
	}

	public List<String> ls(String path) {
		if (path.equals("/"))
			return ls("");
		List<String> s = new ArrayList<>();
		for (Data d : map.get(path).children) {
			s.add(d.path.substring(d.path.lastIndexOf('/') + 1));
		}
		Collections.sort(s);
		return s;
	}

	public void mkdir(String path) {
		String[] parts = path.split("/");
		String prev = "";
		for (int i = 0; i < parts.length - 1; i++) {
			String s = parts[i];
			if (s.equals(""))
				continue;
			String cur = prev + "/" + s;
			if (!map.containsKey(cur)) {
				mkdir(cur);
			}
			prev = cur;
		}
		Data d = new Data(path);
		map.put(path, d);
		int index = path.lastIndexOf('/');
		if (index >= 0) {
			String parent = path.substring(0, index);
			map.get(parent).children.add(d);
		}
	}

	public void addContentToFile(String filePath, String content) {
		String parent = filePath.substring(0, filePath.lastIndexOf('/'));
		if (!map.containsKey(filePath)) {
			Data d = new Data(filePath);
			map.put(filePath, d);

			map.get(parent).children.add(d);
		}
		map.get(filePath).data += content;
		map.get(filePath).children.add(map.get(filePath));
	}

	public String readContentFromFile(String filePath) {
		return map.get(filePath).data;
	}

	public static void main(String[] args) {
		DesignInMemoryFileSystem d = new DesignInMemoryFileSystem();
		// d.ls("/");
		d.mkdir("/goowmfn");
		d.ls("/a/b");
		d.addContentToFile("/a/b/c/d", "hello");
		d.ls("/");
		d.readContentFromFile("/a/b/c/d");
	}
}
