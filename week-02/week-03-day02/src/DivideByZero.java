public class DivideByZero {
    public static void main(String[] args) {
  divider(0);
    }

    public static void divider (int num) {
        try {System.out.println(10/num);}
        catch (ArithmeticException e) {
            System.out.println("Failed");
        }
    }
}
