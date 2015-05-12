public class StudentList {
	private StudentNode head;

	public StudentList(StudentNode head) {
		this.head = head;
	}

	public String toString() {
		return head.toString();
	}

	public StudentList(Student student) {
		this.head = new StudentNode(student, null);
	}

	private class StudentNode {
		private Student student;
		private StudentNode next;

		public StudentNode(Student student, StudentNode next) {
			this.student = student;
			this.next = next;
		}

		public String toString() {
			if (next != null)
				return student.toString() + " " + next.toString();
			return student.toString();
		}
	}

	public void addStart(Student s) {
		head = new StudentNode(s, head);
	}

	public void insertByLastName(Student s) {
		boolean inserted = false;
		StudentNode temp = head;
		if (temp.student.getLastName().compareToIgnoreCase(s.getLastName()) > 0) {
			head = new StudentNode(s, temp);
		}

		while (temp != null
				&& inserted == false
				&& temp.student.getLastName().compareToIgnoreCase(
						s.getLastName()) < 0) {
			StudentNode insert = new StudentNode(s, temp.next);
			temp.next = insert;
			inserted = true;
			temp = temp.next;
		}
	}

	public void traverse() {
		StudentNode temp = head;
		while (temp != null) {
			System.out.println(temp.student.toString());
			temp = temp.next;
		}
		System.out.println("_________________________");
	}

	public void sortByLastName() {
		sortByLastName(head);
	}

	private void sortByLastName(StudentNode node) {
		while (!isSortedByLast()) {
			StudentNode temp = head;
			while (temp != null && temp.next != null) {
				if (temp.student.getLastName().compareToIgnoreCase(
						temp.next.student.getLastName()) > 0) {
					swapNodes(temp, temp.next);
					traverse();
				}
				temp = temp.next;
			}
		}
	}

	private boolean isSortedByLast() {
		StudentNode temp = head;
		while (temp != null) {
			if (temp.student.getLastName().compareToIgnoreCase(
					temp.next.student.getLastName()) > 0)
				return false;
			temp = temp.next;
		}
		return true;
	}

	private void swapNodes(StudentNode n1, StudentNode n2) {
		StudentNode temp = n1;
		StudentNode temp2 = n2;
		n1 = new StudentNode(temp2.student, temp.next);
		n2 = new StudentNode(temp.student, temp2.next);
	}

	public static void main(String[] args) {
		StudentList list = new StudentList(new Student("Thomas", "Edgars", 89));
		list.addStart(new Student("Jennifer", "Smith", 86));
		list.traverse();
		list.sortByLastName();
		list.traverse();
	}

}
