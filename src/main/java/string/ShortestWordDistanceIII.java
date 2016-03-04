package string;

/*

 This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 word1 and word2 may be the same and they represent two individual words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = "makes", word2 = "coding", return 1.
 Given word1 = "makes", word2 = "makes", return 3.

 */

public class ShortestWordDistanceIII {
	public int shortestWordDistance(String[] words, String word1, String word2) {
		int min = Integer.MAX_VALUE;
		int id1 = -1;
		int id2 = -1;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word1) || words[i].equals(word2)) {
				if (word1.equals(word2)) {
					if (id1 != -1) {
						int dis = i - id1;
						min = Math.min(dis, min);
					}
					id1 = i;
				} else {
					if (words[i].equals(word1)) {
						id1 = i;
					} else {
						id2 = i;
					}
					if (id1 != -1 && id2 != -1) {
						int dis = Math.abs(id1 - id2);
						min = Math.min(dis, min);
					}
				}
			}
		}
		return min;
	}
}
