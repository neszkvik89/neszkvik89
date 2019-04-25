import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AnimalTest {
  Animal myAnimal;

  @Before
  public void setup () {
    myAnimal = new Animal();
  }

  @Test
  public void eatShouldDecreaseHungerBy1() {
    myAnimal.eat();
    assertEquals(49, myAnimal.getHunger());
  }

  @Test
  public void drinkShouldDecreaseThirstBy1() {
    myAnimal.drink();
    assertEquals(49, myAnimal.getThirst());
  }

  @Test
  public void playShouldIncreaseThirstAndHungerBy1() {
    myAnimal.play();
    assertEquals(51, myAnimal.getThirst());
    assertEquals(51, myAnimal.getHunger());
  }
}