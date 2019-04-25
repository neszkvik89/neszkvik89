import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CowsAndBulls {
  String nrToGuess = String.valueOf((int) (Math.random() * 9999));
  List<Character> nrChars = new ArrayList<>();
  String playersGuess = "";
  boolean gameOn = true;
  int nrOfGuesses = 0;
  int cowNr = 0;
  int bullNr = 0;

  Scanner sc = new Scanner(System.in);

  public void guess() {
    for (int i = 0; i < nrToGuess.length(); i++) {
      nrChars.add(nrToGuess.charAt(i));
    }

    while (String.valueOf(playersGuess) != nrToGuess) {
      cowNr = 0;
      bullNr = 0;
      System.out.println("Please give me (another) four-digit number");
      System.out.println("Cheat : " + nrToGuess);
      playersGuess = String.valueOf(sc.nextInt());
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
          break;
        }
      }
    System.out.println("You guessed correctly after " + nrOfGuesses + "guesses");
    gameOn = false;
    }

  public static void main(String[] args) {
    CowsAndBulls myGame = new CowsAndBulls();
    myGame.guess();
  }

  }

