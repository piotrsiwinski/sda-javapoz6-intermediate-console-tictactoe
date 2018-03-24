package pl.sda.poznan;

import java.util.Scanner;

public class Main {

  private static Scanner scanner = new Scanner(System.in);

  public static String getPlayerName() {
    System.out.println("Podaj nick: ");
    return scanner.next();
  }

  public static void main(String[] args) {
    Player firstPlayer = new Player(getPlayerName(), PlayerConstants.X_PLAYER_SIGN);
    Player secondPlayer = new Player(getPlayerName(), PlayerConstants.O_PLAYER_SIGN);
    GameBoard gameBoard = new GameBoard();

    Game game = new Game(firstPlayer, secondPlayer, gameBoard);
    boolean gameEnded = false;
    System.out.println("Rozpoczyna gracz " + game.getCurrentPlayer());
    while (!gameEnded) {
      String move = scanner.next();
      GameStatus gameStatus = game.playGame(move);
      gameBoard.print();
      switch (gameStatus) {
        case BAD_MOVE: {
          System.out.println("Zly ruch - wybierz jeszcze raz");
          break;
        }
        case WINNER: {
          gameEnded = true;
          System.out.println("Gra zakończyła sie sukcesem. Gratulacje, " + game.getCurrentPlayer());
          break;
        }
        case CORRECT_MOVE: {
          System.out.println("Teraz kolej gracza: " + game.getCurrentPlayer() + "\n");
        }
      }
    }
  }
}
