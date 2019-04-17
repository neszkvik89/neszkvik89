import java.util.ArrayList;

public class SharpieSet {
    public static void main(String[] args) {
        ArrayList<Sharpie> mySharpies = new ArrayList<>();
        mySharpies.add(new Sharpie(4.31F));
        mySharpies.add(new Sharpie(2.31F));
        mySharpies.add(new Sharpie(0.31F));
        mySharpies.add(new Sharpie(14.31F));
        mySharpies.add(new Sharpie(0.00F));
        mySharpies.add(new Sharpie(41.31F));
        mySharpies.add(new Sharpie(0.01F));
        mySharpies.add(new Sharpie(0.0F));
        mySharpies.add(new Sharpie(4.31F));
        mySharpies.add(new Sharpie(0.76F));

        System.out.println(usable(mySharpies));
        removeTrash(mySharpies);
    }

    public static int usable(ArrayList<Sharpie> sharpieObject) {
        int usable = 0;
        for (int i = 0; i < sharpieObject.size(); i++) {
            if (sharpieObject.get(i).getInkAmount() != 0F) {
                usable++;
            }
        }
        return usable;
    }

    public static void removeTrash(ArrayList<Sharpie> sharpieObject) {
        for (int i = 0; i < sharpieObject.size(); i++) {
            if (sharpieObject.get(i).getInkAmount() == 0F) {
                sharpieObject.remove(i);
            }
        }
        System.out.println(sharpieObject);
    }


}
