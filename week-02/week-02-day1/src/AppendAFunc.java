public class AppendAFunc {

    public static void main(String[] args) {

        String typo = "Karamell";
        System.out.println(appendAFunc(typo));
    }

    public static String appendAFunc (String typo) {
        return new StringBuilder(typo).append("a")
                               .toString();

    }
}
