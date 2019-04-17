public class Sharpie {

    String color = "";
    float width = 0.0F;

    public float getInkAmount() {
        return inkAmount;
    }

    public void setInkAmount(float inkAmount) {
        this.inkAmount = inkAmount;
    }

    float inkAmount = 100.0F;
    public void use(){
        inkAmount--;
    }

    public Sharpie(float inkAmount) {
        this.inkAmount = inkAmount;
    }

    public Sharpie(String color, float width) {
        this.color = color;
        this.width = width;
    }

    public static void main(String[] args) {
        Sharpie theSharpie = new Sharpie("green", 3.49F);
        theSharpie.use();
        System.out.println(theSharpie.inkAmount);
    }

}
