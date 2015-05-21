public class StudentList
    {
	private StudentNode head = null;

	/* Methods */
	/*
	 * public String toString() { return head.toString(); }
	 */

	private class StudentNode
	    {
		private Student student;
		private StudentNode next;

		public StudentNode(Student student, StudentNode next)
		    {
			this.student = student;
			this.next = next;
		    }
	    }

	public static void header(String str)
	    {
		for (int i = 0; i < str.length() - 1; i++)
		    System.out.print("_");
		System.out.println("_");
		System.out.println(str);
		for (int i = 0; i < str.length() - 1; i++)
		    System.out.print("_");
		System.out.println("_");
	    }

	/**
	 * 
	 * @param s
	 *            The Student to be added to the list
	 * @return The Student
	 */
	public Student insertByLastName(Student s)
	    {
		return insertByLastName(new StudentNode(s, null));
	    }

	private Student insertByLastName(StudentNode node)
	{
	if (head == null)
	    {
		head = node;
		head.next = null;
		return node.student;
	    }
	StudentNode temp = head;
	if (temp.student.getLastName().compareToIgnoreCase(node.student.getLastName()) > 0)
	    {
		head = node;
		node.next = temp;
		return node.student;
	    }
	
	while (temp != null && temp.next != null)
	    {
		if (temp.next.student.getLastName().compareToIgnoreCase(
			node.student.getLastName()) > 0)
		    {
			node.next = temp.next;
			temp.next = node;
			return node.student;
		    } else
		    {
			temp = temp.next;
		    }
	    }
	temp.next = node;
	temp.next.next = null;
	return temp.next.student;
	
	}

	public void sortByLastName()
	    {
		sortByLastName(head);
	    }

	private void sortByLastName(StudentNode node)
	    {
		StudentList temp = new StudentList();
		StudentNode spot = head.next;
		temp.head = head;
		temp.head.next = null;
		while (spot != null)
		    {
			StudentNode insert = spot;
			spot = spot.next;
			insert.next = null;
			temp.insertByLastName(insert);
		    }
		head = temp.head;
	    }

	/**
	 * Prints the entire StudentList in the current order
	 */
	public void traverse()
	    {
		StudentNode temp = head;
		while (temp != null)
		    {
			System.out.println(temp.student.toString());
			temp = temp.next;
		    }
		System.out.println("-------------------------");
	    }

	/**
	 * 
	 * @param item
	 *            Student to be removed
	 * @return the Student if he/she is in the list, null if he/she isn't
	 */
	public Student remove(Student item)
	    {
		StudentNode temp = head;
		while (temp != null && temp.next != null)
		    {
			if (temp.next.student == item)
			    {
				Student s = temp.next.student;
				temp.next = temp.next.next;
				return s;
			    }
			temp = temp.next;
		    }
		return null;
	    }

	public Student insertByAverage(Student s)
	{
	return insertByAverage(new StudentNode(s, null));
	}

	private Student insertByAverage(StudentNode node)
	{
	if (head == null)
	    {
		head = node;
		head.next = null;
		return node.student;
	    }
	StudentNode temp = head;
	if (temp.student.getGPA() > node.student.getGPA())
	    {
		head = node;
		node.next = temp;
		return node.student;
	    }
	
	while (temp != null && temp.next != null)
	    {
		if (temp.next.student.getGPA() > node.student.getGPA())
		    {
			node.next = temp.next;
			temp.next = node;
			return node.student;
		    } else
		    {
			temp = temp.next;
		    }
	    }
	temp.next = node;
	temp.next.next = null;
	return temp.next.student;
	
	}

	public void sortByAverage()
	    {
		sortByAverage(head);
	    }

	public void sortByAverage(StudentNode node)
	    {
		StudentList temp = new StudentList();
		StudentNode spot = head.next;
		temp.head = head;
		temp.head.next = null;
		while (spot != null)
		    {
			StudentNode insert = spot;
			spot = spot.next;
			insert.next = null;
			temp.insertByAverage(insert);
		    }
		head = temp.head;
	    }

	public static void main(String[] args)
	    {
		StudentList list = new StudentList();
		Student thomas = list.insertByLastName(new Student("Thomas", "Edgars", 89));
		Student jeniffer = list.insertByLastName(new Student("Jeniffer", "Smith", 86));
		Student harold = list.insertByLastName(new Student("Harold", "Umberton", 78));
		Student frank = list.insertByLastName(new Student("Frank", "Martin", 60));
		Student jeremy = list.insertByLastName(new Student("Jeremy", "Andrews", 83));
		Student laura = list.insertByLastName(new Student("Laura", "Roberts", 93));
		Student adele = list.insertByLastName(new Student("Adele", "Lincoln", 85));
		Student peter = list.insertByLastName(new Student("Peter", "Smith", 91));
		Student larry = list.insertByLastName(new Student("Larry", "Peterson", 72));
		header("Students inserted by last name");
		list.traverse();
		list.remove(frank);
		header("Removed Frank. Poor Frank");
		list.traverse();
			header("Sorted by Average");
		list.sortByAverage();
		list.traverse();
		Student alice = list.insertByAverage(new Student("Alice", "Henderson", 90));
		header("Inserted Alice by averate");
		list.traverse();
		list.sortByLastName();
		header("Resorted by last name");
		list.traverse();
	    }
    }
