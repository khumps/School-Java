public class StudentList {
	private StudentNode head = null;

	/* Methods */
	/*public String toString() {
		return head.toString();
	}*/

	public Student insertByAverage(Student s) {
		return insertByAverage(new StudentNode(s, null));
	}

	private Student insertByAverage(StudentNode node) {
		if (head == null) {
			head = node;
			return node.student;
		}
		StudentNode temp = head;
		if (temp.student.getGPA() > node.student.getGPA()) {
			head = node;
			node.next = temp;
			return node.student;
		}

		while (temp != null && temp.next != null) {
			System.out.println(temp.student.toString());
			if (temp.next.student.getGPA() > node.student.getGPA()) {
				node.next = temp.next;
				temp.next = node;
				System.out.println("IBA loop");
				return node.student;

			} else {
				temp = temp.next;
				System.out.println("IBA out of loop");
			}
		}
		return null;
	}

	public void sortByLastName() {
		sortByLastName(head);
	}

/*	private void sortByLastName(StudentNode node) {
		StudentList temp = new StudentList();
		temp.insertByLastName(head);
		head = head.next;
		StudentNode tempNode = head;
		while (tempNode != null) {

			// System.out.println(temp.toString());
			temp.insertByLastName(tempNode);
			System.out.println(tempNode.student.toString());
			System.out.println("loopran");
			
			head = head.next;
			tempNode = head;
		}
		head = temp.head;
	}*/
	public void sortByLastName(StudentNode node)
	{
		StudentList temp = new StudentList();
		StudentNode spot = head.next;
		temp.head = head;
		temp.head.next = null;
		while(spot != null && spot.next != null)
		{
			StudentNode insert = spot;
			spot = spot.next;
			insert.next = null;
			temp.insertByLastName(insert);

			System.out.println("runnin");
		}
		head = temp.head;
	}

	private Student insertByLastName(StudentNode node) {
		if (head == null) {
			head = node;
			head.next = null;
			return node.student;
		}
		StudentNode temp = head;
		if (temp.student.getLastName().compareToIgnoreCase(
				node.student.getLastName()) > 0) {
			head = node;
			node.next = temp;
			return node.student;
		}

		while (temp != null && temp.next != null) {
			if (temp.next.student.getLastName().compareToIgnoreCase(
					node.student.getLastName()) > 0) {
				node.next = temp.next;
				temp.next = node;
				System.out.println("inserted");
				return node.student;
			} else
			{
				temp = temp.next;
				System.out.println("not inserted");
			}
		}
		temp.next = node;
		temp.next.next = null;
		return temp.next.student;

	}

	public Student insertByLastName(Student s) {
		return insertByLastName(new StudentNode(s, null));
	}

	public void traverse() {
		StudentNode temp = head;
		while (temp != null) {
			System.out.println(temp.student.toString());
			temp = temp.next;
		}
		System.out.println("_________________________");
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

	public void sortByAverage() {
		sortByAverage(head);
	}

	public void sortByAverage(StudentNode node) {
		StudentList temp = new StudentList();
		temp.insertByAverage(head);
		head = head.next;
		while (head != null) {
			StudentNode tempNode = head;
			head = head.next;
			temp.insertByAverage(tempNode);
			// System.out.println(head );

		}
		System.out.println("blah2");
		head = temp.head;
	}

	private class StudentNode {
		private Student student;
		private StudentNode next;

		public StudentNode(Student student, StudentNode next) {
			this.student = student;
			this.next = next;
		}

		/*public String toString() {
			if (next != null)
				return student.toString() + " " + next.toString();
			return "";
		}*/
	}

	public static void main(String[] args) {
		StudentList list = new StudentList();
		Student thomas = list.insertByLastName(new Student("Thomas", "Edgars",
				89));
		Student jeniffer = list.insertByLastName(new Student("Jeniffer",
				"Smith", 86));
		Student harold = list.insertByLastName(new Student("Harold",
				"Umberton", 78));
		Student frank = list
				.insertByLastName(new Student("Frank", "Martin", 60));
		Student jeremy = list.insertByLastName(new Student("Jeremy", "Andrews",
				83));
		Student laura = list.insertByLastName(new Student("Laura", "Roberts",
				93));
		Student adele = list.insertByLastName(new Student("Adele", "Lincoln",
				85));
		Student peter = list
				.insertByLastName(new Student("Peter", "Smith", 91));
		Student larry = list.insertByLastName(new Student("Larry", "Peterson",
				72));
		System.out
				.println("_________ Students inserted by last name _________");
		list.traverse();
		list.remove(frank);
		System.out.println("Removed Frank. Poor Frank");
		System.out.println();
		list.traverse();
/*		for(int i = 0; i < 3; i++)
		{
			System.out.println("BLAH");
			StudentNode node  = list.head;
			System.out.println(node.student.toString());
			list.head = list.head.next;

		}*/
		list.sortByLastName();
		System.out.println("RAN");
		list.traverse();
		/*
		 * System.out.println("test"); list.sortByAverage();
		 * System.out.println("test1"); list.traverse();
		 * System.out.println("test2");
		 */
	}
}
