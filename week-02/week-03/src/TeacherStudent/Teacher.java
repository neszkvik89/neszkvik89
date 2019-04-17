package TeacherStudent;

public class Teacher {

    public Teacher() {
    }

    public void teach(Student studentName) {
        studentName.learn();
    }

    public void answer() {
        System.out.println("Teacher answered.");
    }


}


