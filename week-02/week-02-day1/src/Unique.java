import java.util.Arrays;

public class Unique {

    public static void main(String[] args) {
        unique(new int [] {2, 66, 43, 34, 66, 2, 2, 23});
    }

    public static int [] unique (int [] duplicates) {

        int length = 1;
        int pos = 0;

        Arrays.sort(duplicates);

        for (int i = 0; i < duplicates.length -1; i++) {
            if (duplicates[i] == duplicates [i+1]) {
                duplicates[i] = 0;
            }
            else {
                length++;
            }
        }

        int [] noDuplicates = new int [length];

        for (int i = 0; i < duplicates.length; i++) {
            if (duplicates[i] != 0 ) {
                noDuplicates[pos] = duplicates[i];
                System.out.println(noDuplicates[pos]);
                pos++;

            }

        }
        System.out.println(noDuplicates[noDuplicates.length-1]);
        return noDuplicates;
    }
}
