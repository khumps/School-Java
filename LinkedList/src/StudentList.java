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

	public void insertByAverage(Student s) {
		insertByAverage(new StudentNode(s, null));
	}

	private void insertByAverage(StudentNode node) {
		boolean inserted = false;
		StudentNode temp = head;
		if (temp.student.getGPA() > node.student.getGPA()) {
			head = node;
			node.next = temp;
		} else {

			while (temp != null && temp.next != null && inserted == false) {
				if (temp.next.student.getGPA() > node.student.getGPA())
					inserted = true;
				else
					temp = temp.next;
			}

			node.next = temp.next;
			temp.next = node;
		}
	}

	public void sortByAverage() {
		sortByAverage(head);
	}

	public void sortByAverage(StudentNode node) {
		StudentList temp = new StudentList(head);
		StudentNode tempNode = head.next;
		while (head != null && head.next != null) {
			temp.insertByAverage(tempNode);
			tempNode = tempNode.next;

		}
		head = temp.head;
	}

	public void insertByLastName(Student s) {
		insertByLastName(new StudentNode(s, null));
	}

	private void insertByLastName(StudentNode node) {
		boolean inserted = false;
		StudentNode temp = head;
		if (temp.student.getLastName().compareToIgnoreCase(
				node.student.getLastName()) > 0) {
			head = node;
			node.next = temp;
			inserted = true;
		} else {

			while (temp != null && temp.next != null && inserted == false) {
				if (temp.next.student.getLastName().compareToIgnoreCase(
						node.student.getLastName()) > 0)
					inserted = true;
				else
					temp = temp.next;
			}

			node.next = temp.next;
			temp.next = node;
		}

	}

	public void sortByLastName() {
		sortByLastName(head);
	}

	private void sortByLastName(StudentNode node) {
		StudentList temp = new StudentList(new StudentNode(head.student, null));
		// Just use the StudentNode
		head = head.next;
		while (head != null) {
			StudentNode tempNode = head;
			head = head.next;
			temp.insertByLastName(tempNode);

		}
		head = temp.head;
	}

	public void traverse() {
		StudentNode temp = head;
		while (temp != null) {
			System.out.println(temp.student.toString());
			temp = temp.next;
		}
		System.out.println("_________________________");
	}

	public static void main(String[] args) {
		StudentList list = new StudentList(new Student("Thomas", "Edgars", 89));
		list.addStart(new Student("Jennifer", "Smith", 86));
		list.addStart(new Student("Bob", "fob", 77));
		list.addStart(new Student("Bob", "zob", 77));

/*		list.traverse();
		//list.sortByAverage();
		list.traverse();
		list.traverse();*/
	}

}
