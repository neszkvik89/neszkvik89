import java.util.ArrayList;

public class Sum {
    public int sum (ArrayList<Integer> toSum) {
        int total = 0;
        for (int i = 0; i < toSum.size(); i++) {
            total += toSum.get(i);
        }
        return total;
    }
}
