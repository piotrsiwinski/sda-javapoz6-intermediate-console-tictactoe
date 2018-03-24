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

  private int parseInput(String move) {

    return Integer.parseInt(move);

  }
  public GameStatus playGame(String move) {
    int position;
    try {
      position = Integer.parseInt(move);
    } catch (NumberFormatException ex) {
      return GameStatus.INVALID_INPUT;
    }

    if (!gameBoard.isValidMove(position)) {
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
