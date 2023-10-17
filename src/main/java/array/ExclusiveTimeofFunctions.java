package array;

import java.util.List;
import java.util.Stack;

public class ExclusiveTimeofFunctions {

	public class Data {
		int id;
		int start_time;
		int run_time;

		public Data(int id, int start_time, int run_time) {
			super();
			this.id = id;
			this.start_time = start_time;
			this.run_time = run_time;
		}
	}

	public int[] exclusiveTime(int n, List<String> logs) {
		int[] res = new int[n];

		Stack<Data> stack = new Stack<>();
		for (String s : logs) {
			String[] parts = s.split(":");
			int id = Integer.parseInt(parts[0]);
			String event = parts[1];
			int time = Integer.parseInt(parts[2]);

			if (event.equals("end")) {
				Data d = stack.pop();
				res[id] += time - d.start_time + 1 + d.run_time;
				if (!stack.isEmpty()) {
					stack.peek().start_time = time + 1;
				}
			} else {
				if (!stack.isEmpty()) {
					stack.peek().run_time += time - stack.peek().start_time;
				}
				stack.push(new Data(id, time, 0));
			}

		}
		return res;
	}
}
