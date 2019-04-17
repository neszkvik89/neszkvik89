package TeacherStudent;

public class Student {
    public static void main(String[] args) {
        Student tom = new Student();
        Teacher anna = new Teacher();
        tom.question(anna);
        anna.teach(tom);
    }

    public void learn () {
        System.out.println("Student learned based on the answer.");
    }

    public void question(Teacher teacherName) {
        teacherName.answer();
    }

}
