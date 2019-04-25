import org.junit.*;

import static junit.framework.TestCase.assertEquals;

public class SharpieTest {
  Sharpie mySharpie;

  @Before
  public void setup() {
    mySharpie = new Sharpie("Green", 10);
  }

  @Test
  public void getInkAmountShouldReturnSetInkAmount() {
    mySharpie.setInkAmount(17.42F);
    float expected = 17.42F;
    assertEquals(expected, (float) (mySharpie.getInkAmount()));
  }

  @Test
  public void useShouldReduceInkAmountBy1() {
    mySharpie.use();
    assertEquals(99F, mySharpie.getInkAmount());
  }
}