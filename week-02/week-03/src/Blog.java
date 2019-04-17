import java.util.ArrayList;

public class Blog {

    private ArrayList<BlogPost> myBlogPosts = new ArrayList<>();

    public Blog(ArrayList<BlogPost> myBlogPosts) {
        this.myBlogPosts = myBlogPosts;
    }

    public void delete (int index) {
        this.myBlogPosts.remove(index);
    }

    public void update (int index, BlogPost newContent) {
        this.myBlogPosts.get(index).setAuthorName(newContent.getAuthorName());
        this.myBlogPosts.get(index).setPublicationDate(newContent.getPublicationDate());
        this.myBlogPosts.get(index).setText(newContent.getText());
        this.myBlogPosts.get(index).setTitle(newContent.getTitle());
    }

    public static void main(String[] args) {
        ArrayList<BlogPost> myBlogPosts = new ArrayList<>();
        BlogPost toUpdate = new BlogPost("Kis Béla", "Béláék", "Béláék álmodtak", "2019.04.17.");
        myBlogPosts.add(new BlogPost("john Doe", "Lorem ipsum", "Lorem ipsum dolor sit amet.", "2000.05.04."));
        myBlogPosts.add(new BlogPost("Tim Urban", "Wait but why", "A popular long-form, stick-figure-illustrated blog about almost everything.", "2010.10.10."));
        myBlogPosts.add(new BlogPost("William Turton", "One Engineer Is Trying to Get IBM to Reckon With Trump", "Daniel Hanley, a cybersecurity engineer at IBM, doesn’t want to be the center of attention. When I asked to take his picture outside one of IBM’s New York City offices, he told me that he wasn’t really into the whole organizer profile thing.", "2017.03.28"));
        Blog myBlog = new Blog(myBlogPosts);
        myBlog.delete(1);
        myBlog.update(2, toUpdate);
    }
}
