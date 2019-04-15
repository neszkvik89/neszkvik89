public class test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("poWE");
        sb.append("rpo");
        sb.append("nt");
        sb.append(" 4ev");
        sb.insert(7, 'i');
        sb.append("er");
        sb.reverse(); //what, reversing a string without a loop? :D
        System.out.println(sb.toString());
    }
}
