package design;

public class ReadNCharactersGivenRead4 {
	/*
	 * Given a file and assume that you can only read the file using a given
	 * method read4, implement a method to read n characters.
	 * 
	 * Method read4:
	 * 
	 * The API read4 reads four consecutive characters from file, then writes
	 * those characters into the buffer array buf4.
	 * 
	 * The return value is the number of actual characters read.
	 * 
	 * Note that read4() has its own file pointer, much like FILE *fp in C.
	 * 
	 * 
	 */
	int read4(char[] buf4) {
		return 0;
	}

	public int read(char[] buf, int n) {
		char[] buf4 = new char[4];
		int index = 0;
		while (n > 0) {
			int read = Math.min(read4(buf4), n);
			for (int i = 0; i < read; i++) {
				buf[index++] = buf4[i];
			}
			n = n - 4;
		}
		return index;
	}
}
