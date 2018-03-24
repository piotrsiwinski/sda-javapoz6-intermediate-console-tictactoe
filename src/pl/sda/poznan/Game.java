package pl.sda.poznan;

public class Game {

  private Player currentPlayer;
  private GameBoard gameBoard;

  public Game(Player firstPlayer, Player secondPlayer, GameBoard gameBoard) {
    this.gameBoard = gameBoard;
    this.currentPlayer = firstPlayer;
    firstPlayer.setOpponent(secondPlayer);
    secondPlayer.setOpponent(firstPlayer);
  }

  public GameStatus playGame(String move) {
    if (!gameBoard.isValidMove(move)) {
      return GameStatus.BAD_MOVE;
    }
    boolean isWinner = gameBoard.add(move, currentPlayer.getSign());
    if (isWinner) {
      return GameStatus.WINNER;
    } else {
      this.currentPlayer = currentPlayer.getOpponent();
      return GameStatus.CORRECT_MOVE;
    }
  }

  public Player getCurrentPlayer() {
    return currentPlayer;
  }
}
