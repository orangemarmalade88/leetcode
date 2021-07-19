package graph;

public class LonelyPixelI {
	/*
	 * Given an m x n picture consisting of black 'B' and white 'W' pixels,
	 * return the number of black lonely pixels.
	 * 
	 * A black lonely pixel is a character 'B' that located at a specific
	 * position where the same row and same column don't have any other black
	 * pixels.
	 * 
	 * 
	 */
	public int findLonelyPixel(char[][] picture) {
		int m = picture.length;
		int n = picture[0].length;
		boolean[] lonely_r = new boolean[m];
		boolean[] lonely_c = new boolean[n];
		for (int i = 0; i < m; i++) {
			int count = 0;
			for (int j = 0; j < n; j++) {
				if (picture[i][j] == 'B') {
					count++;
				}
			}
			if (count == 1)
				lonely_r[i] = true;
		}
		for (int j = 0; j < n; j++) {
			int count = 0;
			for (int i = 0; i < m; i++) {
				if (picture[i][j] == 'B') {
					count++;
				}
			}
			if (count == 1)
				lonely_c[j] = true;
		}

		int lone = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] == 'B' && lonely_r[i] && lonely_c[j])
					lone++;
			}
		}
		return lone;
	}
}
