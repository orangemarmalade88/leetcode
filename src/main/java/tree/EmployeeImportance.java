package tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Employee;

public class EmployeeImportance {
	/*
	 * 690. Employee Importance
	 * 
	 * You are given a data structure of employee information, which includes
	 * the employee's unique id, their importance value and their direct
	 * subordinates' id.
	 * 
	 * For example, employee 1 is the leader of employee 2, and employee 2 is
	 * the leader of employee 3. They have importance value 15, 10 and 5,
	 * respectively. Then employee 1 has a data structure like [1, 15, [2]], and
	 * employee 2 has [2, 10, [3]], and employee 3 has [3, 5, []]. Note that
	 * although employee 3 is also a subordinate of employee 1, the relationship
	 * is not direct.
	 * 
	 * Now given the employee information of a company, and an employee id, you
	 * need to return the total importance value of this employee and all their
	 * subordinates.
	 * 
	 */
	public int getImportance(List<Employee> employees, int id) {
		Map<Integer, Employee> map = new HashMap<Integer, Employee>(
				employees.size());
		for (Employee e : employees) {
			map.put(e.id, e);
		}
		return getImportance(map, id);
	}

	public int getImportance(Map<Integer, Employee> map, int id) {
		Employee e = map.get(id);
		int sum = e.importance;
		for (int sub : e.subordinates) {
			sum += getImportance(map, sub);
		}
		return sum;
	}
}
