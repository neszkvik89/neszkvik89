import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CowsAndBulls {
  String nrToGuess = String.valueOf((int) (Math.random() * 9999) + 1000);
  List<Character> nrChars = new ArrayList<>();
  String playersGuess = "";
  boolean gameOn = true;
  int nrOfGuesses = 0;
  int cowNr = 0;
  int bullNr = 0;

  Scanner sc = new Scanner(System.in);

  public void setup() {
    cowNr = 0;
    bullNr = 0;
    System.out.println("Please give me (another) four-digit number");
    System.out.println("Cheat : " + nrToGuess);
  }

  public boolean isNumber(String string) {
    String digits = "0123456789";

    for (char c : string.toCharArray()) {
      if (!digits.contains("" + c)) {
        return false;
      }
    }
    return true;
  }

  public void guess() {
    for (int i = 0; i < nrToGuess.length(); i++) {
      nrChars.add(nrToGuess.charAt(i));
    }

    while (cowNr != 4) {
      setup();
      if (isNumber(playersGuess)) {
        playersGuess = String.valueOf(sc.next());
        if (playersGuess.length() == 4) {
          nrOfGuesses++;
          for (int i = 0; i < playersGuess.length(); i++) {
            if (nrChars.contains(playersGuess.charAt(i))) {
              bullNr++;
            }
            if (playersGuess.charAt(i) == nrToGuess.charAt(i)) {
              cowNr++;
              bullNr--;
            }
          }
          System.out.println(cowNr + " cow(s), " + bullNr + " bull(s)");
          if (cowNr == 4) {
            System.out.println("You guessed correctly after " + nrOfGuesses + " valid guesses");
            gameOn = false;
            break;
          }
        } else {
          System.out.println("That is not a valid four-digit number. Please give me another one.");
        }
      } else {
        System.out.println("That is not a valid four-digit number. Please give me another one");
        playersGuess = String.valueOf(sc.next());
      }
    }
  }

  public static void main(String[] args) {
    CowsAndBulls myGame = new CowsAndBulls();
    myGame.guess();
  }
}

