package design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class DesignaTodoList {

	class Task {
		int taskId;
		int userId;
		int dueDate;
		String taskDescription;
		List<String> tags;

		public Task(int taskId, int userId, int dueDate, String taskDescription,
				List<String> tags) {
			super();
			this.taskId = taskId;
			this.userId = userId;
			this.dueDate = dueDate;
			this.taskDescription = taskDescription;
			this.tags = tags;
		}

	}

	int next_id = 1;
	Map<Integer, Set<Task>> taskMap = new HashMap<>();
	// user_id ->

	Map<String, Set<Task>> tagMap = new HashMap<>();
	// user_id:tag -> <taskId -> Tasks>

	Map<Integer, Task> taskIdMap = new HashMap<>();
	// task_id -> Task

	public DesignaTodoList() {

	}

	public int addTask(int userId, String taskDescription, int dueDate,
			List<String> tags) {
		int task_id = next_id;
		Task t = new Task(task_id, userId, dueDate, taskDescription, tags);

		Set<Task> set1 = taskMap.getOrDefault(userId,
				new TreeSet<>((o1, o2) -> o1.dueDate - o2.dueDate));
		set1.add(t);
		taskMap.put(userId, set1);

		for (String s : tags) {
			String tagKey = userId + ":" + s;
			Set<Task> set = tagMap.getOrDefault(tagKey,
					new TreeSet<>((o1, o2) -> o1.dueDate - o2.dueDate));
			set.add(t);
			tagMap.put(tagKey, set);
		}

		taskIdMap.put(task_id, t);

		next_id++;
		return task_id;
	}

	public List<String> getAllTasks(int userId) {
		List<String> res = new ArrayList<>();
		Set<Task> s = taskMap.get(userId);
		if (s == null)
			return res;
		for (Task t : s) {
			res.add(t.taskDescription);
		}
		return res;
	}

	public List<String> getTasksForTag(int userId, String tag) {
		String key = userId + ":" + tag;

		List<String> res = new ArrayList<>();
		Set<Task> s = tagMap.get(key);
		if (s == null)
			return res;
		for (Task t : s) {
			res.add(t.taskDescription);
		}
		return res;
	}

	public void completeTask(int userId, int taskId) {
		Task t = taskIdMap.get(taskId);
		if (t == null || t.userId != userId) {
			return;
		}

		Set<Task> set1 = taskMap.get(userId);
		if (set1 != null)
			set1.remove(t);

		List<String> tags = t.tags;
		for (String s : tags) {
			String tagKey = userId + ":" + s;
			Set<Task> set2 = tagMap.get(tagKey);
			if (set2 != null) {
				set2.remove(t);
			}
		}

		taskIdMap.remove(taskId);
	}
}
