package GreenFoxInheritance;

public class Person {

    String name = "Jane Doe";
    int age = 30;
    String gender = "female";

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }

    public void introduce() {
        System.out.println("Hi, I'm " + this.name + " a " + this.age + " years old " + this.gender);
    }

    public void getGoal() {
        System.out.println("My goal is: Live for the moment!");
    }

    public static void main(String[] args) {

    }
}
