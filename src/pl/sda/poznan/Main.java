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
    firstPlayer.setOpponent(secondPlayer);
    secondPlayer.setOpponent(firstPlayer);
    GameBoard gameBoard = new GameBoard();

    Game game = new Game(firstPlayer, secondPlayer, gameBoard);
    boolean gameEnded = false;
    while (!gameEnded) {
      String move = scanner.next();
      GameStatus gameStatus = game.playGame(move);
      switch (gameStatus) {
        case CORRECT_MOVE: {
          break;
        }
        case BAD_MOVE: {

        }
        case WINNER:
          System.out.println("GAME ENDED");
          break;
      }
    }
//    //////////////////////////////////////////////////////////////////
//    boolean currentPlayer = false;
//    char playerSign = 'X';
//    System.out.println("Rozpoczyna gracz" + playerSign);
//    while (!gameEnded) {
//      System.out.println("\nKolej gracza " + playerSign + ". Podaj pozycje [0-8]");
//      String position = scanner.next();
//      if (gameBoard.isValidMove(position, playerSign)) {
//        boolean isWinner = gameBoard.add(position, playerSign);
//        currentPlayer = !currentPlayer;
//        gameEnded = isWinner;
//        gameBoard.print();
//        if (gameEnded) {
//          break;
//        }
//        playerSign = !currentPlayer ? 'X' : '0';
//
//      } else {
//        System.out.println("Zla pozycja. Podaj jeszcze raz");
//      }
//    }
//    System.out.println("Wygral gracz" + playerSign);
//  }
}
