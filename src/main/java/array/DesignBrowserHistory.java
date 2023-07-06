package array;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory {
	List<String> stack = new ArrayList<String>();
	int index = 0;

	public DesignBrowserHistory(String homepage) {
		stack.add(homepage);
	}

	public void visit(String url) {
		while (index + 1 < stack.size()) {
			stack.remove(index + 1);
		}
		stack.add(url);
		index++;
	}

	public String back(int steps) {
		if (steps > index) {
			index = 0;
			return stack.get(0);
		}
		index -= steps;
		return stack.get(index);
	}

	public String forward(int steps) {
		if (index + steps >= stack.size()) {
			index = stack.size() - 1;
			return stack.get(index);
		}
		index += steps;
		return stack.get(index);
	}
}
