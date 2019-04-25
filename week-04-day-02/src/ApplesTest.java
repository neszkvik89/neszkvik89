import static org.junit.Assert.*;

public class ApplesTest {


    @org.junit.Before
    public void setUp() throws Exception {
        Apples myApple;
        myApple = new Apples();
    }

    @org.junit.Test
    public void iShouldGetApple() {
        Apples myApple = new Apples();
        assertEquals("appel", myApple.getApple());
    }
}