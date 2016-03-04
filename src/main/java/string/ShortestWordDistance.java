package string;

/*

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = "coding", word2 = "practice", return 3.
 Given word1 = "makes", word2 = "coding", return 1.

 Note:
 You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.

 */

public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
		int id1 = -1;
		int id2 = -1;
		int shortest = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1)) {
				id1 = i;
			} else if (words[i].equals(word2)) {
				id2 = i;
			}
			if (id1 != -1 && id2 != -1) {
				int dis = Math.abs(id1 - id2);
				if (dis < shortest)
					shortest = dis;
			}
		}
		return shortest;
	}

}
