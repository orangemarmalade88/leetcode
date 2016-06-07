package array;

public class ReadNCharactersGivenRead4 {

	int read4(char[] buf) {
		return 4;
	}

	char[] temp = new char[8];
	int ptr = 0;
	int temp_size = 0;

	public int read(char[] buf, int n) {
		int i = 0;

		while (i < n) {

			if (temp_size > 0) {
				if (n - i <= temp_size) {
					for (; i < n; i++) {
						buf[i] = temp[ptr++];
						temp_size--;
					}
				} else {
					for (int j = 0; j < temp_size; j++) {
						buf[i++] = temp[ptr++];
						temp_size--;
					}
					ptr = 0;
				}
			} else {
				read4(temp);
				temp_size += 4;
			}
		}

		return n;
	}
}
