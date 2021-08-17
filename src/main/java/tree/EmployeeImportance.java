package tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Employee;

public class EmployeeImportance {
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<>();
		for (Employee e : employees) {
			map.put(e.id, e);
		}
		return get(map, id);

	}

	public int get(Map<Integer, Employee> map, int id) {
		Employee e = map.get(id);
		int count = e.importance;
		for (int sub : e.subordinates) {
			count += get(map, sub);
		}
		return count;
	}
}
