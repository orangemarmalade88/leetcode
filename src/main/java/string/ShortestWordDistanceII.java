package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

 This is a follow up of Shortest Word Distance.
 The only difference is now you are given the list of words and your method will be called repeatedly many times with different parameters.
 How would you optimize it?

 Design a class which receives a list of words in the constructor,
 and implements a method that takes two words word1 and word2 and return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = "coding", word2 = "practice", return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 */

public class ShortestWordDistanceII {
	public class WordDistance {

		Map<String, List<Integer>> map = new HashMap<>();

		public WordDistance(String[] words) {
			for (int i = 0; i < words.length; i++) {
				if (map.containsKey(words[i])) {
					map.get(words[i]).add(i);
				} else {
					List<Integer> l = new ArrayList<>();
					l.add(i);
					map.put(words[i], l);
				}
			}
		}

		public int shortest(String word1, String word2) {
			int min = Integer.MAX_VALUE;
			List<Integer> ids1 = map.get(word1);
			List<Integer> ids2 = map.get(word2);
			int i = 0;
			int j = 0;
			while (i < ids1.size() && j < ids2.size()) {
				int id1 = ids1.get(i);
				int id2 = ids2.get(j);
				int dis = Math.abs(id1 - id2);
				if (dis < min)
					min = dis;
				if (id1 < id2)
					i++;
				else
					j++;
			}
			return min;

		}
	}
}
