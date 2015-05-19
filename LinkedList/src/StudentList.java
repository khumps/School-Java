public class StudentList {
    private StudentNode head = null;

    public static void main(String[] args) {
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
        System.out
                .println("_________ Students inserted by last name _________");
        list.traverse();
        list.remove(frank);
        System.out.println("Removed Frank. Poor Frank");
        System.out.println();
        list.traverse();
        System.out.println("test");
        list.sortByAverage();
        System.out.println("test1");
        list.traverse();
        System.out.println("test2");
    }

    public String toString() {
        return head.toString();
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
            if (temp.next.student.getGPA() > node.student.getGPA()) {
                node.next = temp.next;
                temp.next = node;
                return node.student;
            } else
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

        }
        head = temp.head;
    }

    public Student insertByLastName(Student s) {
        return insertByLastName(new StudentNode(s, null));
    }

    private Student insertByLastName(StudentNode node) {
        if (head == null) {
            head = node;
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
                return node.student;
            } else
                temp = temp.next;
        }
        temp.next = node;
        return null;

    }

    public void sortByLastName() {
        sortByLastName(head);
    }

    private void sortByLastName(StudentNode node) {
        StudentList temp = new StudentList();
        temp.insertByLastName(head);
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
}
