public class PostIt {

    public static void main(String[] args) {

    }

    String backgroundColor = "";
    String textColor = "";
    String text = "";
    public PostIt (String backgroundColor, String textColor, String text) {
        this.backgroundColor = backgroundColor;
        this.textColor = textColor;
        this.text = text;
    }

    PostIt first = new PostIt("orange", "blue", "Idea");
    PostIt second = new PostIt("pink", "black", "Awesome");
    PostIt third = new PostIt("yellow", "green", "Superb!");
}


