public class Counter {

    int counter = 0;
    int original = 0;

    public Counter(int counter) {
        this.counter = counter;
        this.original = counter;
    }

    public Counter() {
    }

    public void add(int number) {
        this.counter += number;
    }

    public void add() {
        this.counter++;
    }

    public int get() {
        return counter;
    }

    public void reset() {
        this.counter = this.original;
    }

    public static void main(String[] args) {

    }
}
