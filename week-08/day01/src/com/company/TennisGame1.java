package com.company;

public class TennisGame1 implements TennisGame {

  private String gameScore = "";
  private int p1Score = 0;
  private int p2Score = 0;
  private String player1Name;
  private String player2Name;

  public String getGameScore() {
    return gameScore;
  }

  public void setGameScore(String gameScore) {
    this.gameScore = gameScore;
  }

  public int getP1Score() {
    return p1Score;
  }

  public void setP1Score(int p1Score) {
    this.p1Score = p1Score;
  }

  public int getP2Score() {
    return p2Score;
  }

  public void setP2Score(int p2Score) {
    this.p2Score = p2Score;
  }

  public String getPlayer1Name() {
    return player1Name;
  }

  public void setPlayer1Name(String player1Name) {
    this.player1Name = player1Name;
  }

  public String getPlayer2Name() {
    return player2Name;
  }

  public void setPlayer2Name(String player2Name) {
    this.player2Name = player2Name;
  }

  public TennisGame1(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  public void wonPoint(String playerName) {
    if (playerName == this.getPlayer1Name())
      this.setP1Score(this.getP1Score() + 1);
    else
      this.setP2Score(this.getP2Score() + 1);
  }

  public String getScore() {
    int tempScore;
    if (this.getP1Score() == this.getP2Score()) {
      returnEqualScores();
    } else if (p1Score >= 4 || p2Score >= 4) {
      int minusResult = p1Score - p2Score;
      if (minusResult == 1) this.setGameScore("Advantage " + this.getPlayer1Name());
      else if (minusResult == -1) this.setGameScore("Advantage " + this.getPlayer2Name());
      else if (minusResult >= 2) this.setGameScore("Win for " + this.getPlayer1Name());
      else this.setGameScore("Win for " + this.getPlayer2Name());
    } else {
      for (int i = 1; i < 3; i++) {
        if (i == 1) tempScore = p1Score;
        else {
          this.setGameScore(this.getGameScore() + "-");
          tempScore = p2Score;
        }
        switch (tempScore) {
          case 0:
            this.setGameScore(this.getGameScore() + "Love");
            break;
          case 1:
            this.setGameScore(this.getGameScore() + "Fifteen");
            break;
          case 2:
            this.setGameScore(this.getGameScore() + "Thirty");
            break;
          case 3:
            this.setGameScore(this.getGameScore() + "Forty");
            break;
        }
      }
    }
    return this.getGameScore();
  }

  public void returnEqualScores () {
    switch (this.getP1Score()) {
      case 0:
        this.setGameScore("Love-All");
        break;
      case 1:
        this.setGameScore("Fifteen-All");
        break;
      case 2:
        this.setGameScore("Thirty-All");
        break;
      case 3:
        this.setGameScore("Forty-All");
        break;
      default:
        this.setGameScore("Deuce");
        break;

    }
  }
}
