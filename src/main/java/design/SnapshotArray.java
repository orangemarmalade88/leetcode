package design;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SnapshotArray {

	class Change {
		int snapshot_id;
		int value;

		public Change(int snapshot_id, int value) {
			super();
			this.snapshot_id = snapshot_id;
			this.value = value;
		}
	}

	List<List<Change>> snapshots = new ArrayList<>();
	// snapshot_id -> value

	List<int[]> changes = new ArrayList<>();
	// index -> value

	int next_id = 0;

	public SnapshotArray(int length) {
		for (int i = 0; i < length; i++) {
			snapshots.add(new ArrayList<>());
		}
	}

	public void set(int index, int val) {
		changes.add(new int[] { index, val });
	}

	public int snap() {
		int snap_id = next_id;
		for (int[] c : changes) {
			List<Change> history = snapshots.get(c[0]);
			history.add(new Change(snap_id, c[1]));
		}
		next_id++;
		changes = new ArrayList<>();
		return snap_id;
	}

	public int get(int index, int snap_id) {
		List<Change> history = snapshots.get(index);
		Change c = new Change(snap_id, 0);
		int i = Collections.binarySearch(history, c,
				(o1, o2) -> o1.snapshot_id - o2.snapshot_id);
		if (i >= 0) {
			while (i + 1 < history.size()
					&& history.get(i + 1).snapshot_id == snap_id) {
				i++;
			}
		} else {
			i = -i - 2;
		}
		return (i == history.size() || i < 0) ? 0 : history.get(i).value;
	}

	public static void main(String[] args) {
		SnapshotArray sa = new SnapshotArray(3);
		sa.set(0, 5);
		sa.snap();
		sa.set(0, 6);
		sa.get(0, 0);
	}
}
