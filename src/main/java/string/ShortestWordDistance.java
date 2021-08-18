package string;

public class ShortestWordDistance {
	public int shortestDistance(String[] wordsDict, String word1,
			String word2) {
		int last1 = -1;
		int last2 = -1;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < wordsDict.length; i++) {
			if (word1.equals(wordsDict[i])) {
				if (last2 != -1 && i - last2 < min)
					min = i - last2;
				last1 = i;
			} else if (word2.equals(wordsDict[i])) {
				if (last1 != -1 && i - last1 < min)
					min = i - last1;
				last2 = i;
			}

		}
		return min;
	}
}
