package GreenFoxInheritance;

public class Sponsor extends Person {

    String company = "Google";
    int hiredStudents =  0;

    public Sponsor(String name, int age, String gender, String company) {
        super(name, age, gender);
        this.company = company;
    }

    public Sponsor() {
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm " + this.name + " , a " + this.age + " years old " + this.gender + " who represents " + company + " and hired " + hiredStudents + " students so far.");
    }

    public void hire() {
        this.hiredStudents++;
    }

    @Override
    public void getGoal() {
        System.out.println("Hire brilliant junior software developers.");
    }

    public static void main(String[] args) {

    }
}
