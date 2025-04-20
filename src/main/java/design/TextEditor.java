package design;

class TextEditor {

	StringBuilder sb = new StringBuilder();
	int pos = 0;

	public TextEditor() {

	}

	public void addText(String text) {
		sb.insert(pos, text);
		pos += text.length();
	}

	public int deleteText(int k) {
		int start = pos - k;
		if (start < 0)
			start = 0;
		sb.delete(start, pos);
		int deleted = pos - start;
		pos = start;

		return deleted;
	}

	public String cursorLeft(int k) {
		pos -= k;
		if (pos < 0)
			pos = 0;
		int count = Math.min(10, pos);
		return sb.substring(pos - count, pos);
	}

	public String cursorRight(int k) {
		pos += k;
		if (pos >= sb.length()) {
			pos = sb.length();
		}
		int count = Math.min(10, pos);
		return sb.substring(pos - count, pos);
	}
}
