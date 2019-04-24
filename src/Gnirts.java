import java.util.stream.IntStream;

public class Gnirts implements CharSequence {
    String toReverse;

    public Gnirts(String toReverse) {
        this.toReverse = toReverse;
    }

    @Override
    public int length() {
        return this.toReverse.length();
    }

    @Override
    public char charAt(int index) {
        return this.toReverse.charAt(length() - 1 - index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.toReverse.substring(start, end);
    }

    @Override
    public IntStream chars() {
        return null;
    }

    @Override
    public IntStream codePoints() {
        return null;
    }

    public static void main(String[] args) {
        Gnirts myGnirts = new Gnirts("kutyámajom");
        System.out.println(myGnirts.charAt(2));

    }
}



