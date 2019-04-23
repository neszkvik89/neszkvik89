package GreenFoxInheritance;

import java.util.ArrayList;
import java.util.List;

public class Cohort {

    String name = "";
    List<Student> students = new ArrayList<>();
    List<Mentor> mentors = new ArrayList<>();

    public Cohort(String name) {
        this.name = name;
    }

    public void addStudent (Student toAdd) {
        this.students.add(toAdd);
    }

    public void addMentor(Mentor toAdd) {
        this.mentors.add(toAdd);
    }

    public void info () {
        System.out.println("The " + name + " cohort has " + this.students.size() + " students and " + mentors.size() + " mentors.");

    }

    public static void main(String[] args) {

    }
}
