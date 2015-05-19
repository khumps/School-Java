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

		public boolean equals( node) {
			if(student.getLastName().equals(node.student.getLastName()))
		}

		public String toString() {
			if (next != null)
				return student.toString() + " " + next.toString();
			return student.toString();
		}
	}

	public Student remove(Student item) {
		StudentNode temp = head;
		while (temp != null && temp.next != null) {
			if (temp.equals(item)) {
				Student s = temp.next.student;
				temp.next = temp.next.next;
				return s;
			}
			temp = temp.next;
		}
		return null;
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
		StudentList temp = new StudentList(new StudentNode(head.student, null));
		head = head.next;
		while (head != null) {
			StudentNode tempNode = head;
			head = head.next;
			temp.insertByAverage(tempNode);

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
		list.insertByLastName(new Student("Jeniffer", "Smith", 86));
		list.insertByLastName(new Student("Harold", "Umberton", 78));
		list.insertByLastName(new Student("Frank", "Martin", 60));
		list.insertByLastName(new Student("Jeremy", "Andrews", 83));
		list.insertByLastName(new Student("Laura", "Roberts", 93));
		list.insertByLastName(new Student("Adele", "Lincoln", 85));
		list.insertByLastName(new Student("Peter", "Smith", 91));
		list.insertByLastName(new Student("Larry", "Peterson", 72));
		System.out
				.println("_________ Students inserted by last name _________");
		list.traverse();
		System.out.println(list.remove(new Student("Frank", "Martin", 60)));
		list.traverse();
		list.sortByAverage();
		list.traverse();
	}
}
