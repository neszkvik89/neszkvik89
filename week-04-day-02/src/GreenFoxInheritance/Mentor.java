package GreenFoxInheritance;

public class Mentor extends Person{

    String level = "intermediate";

    public Mentor(String name, int age, String gender, String level) {
        super(name, age, gender);
        this.level = level;
    }

    public Mentor() {
    }

    @Override
    public void getGoal() {
        System.out.println("Educate brilliant junior software developers");
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + this.name + " , a " + this.age + " years old " + this.gender + this.level + " mentor");
    }

    public static void main(String[] args) {

    }
}
