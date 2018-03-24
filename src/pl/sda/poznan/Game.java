package pl.sda.poznan;

public class Game {

  private Player currentPlayer;
  private Player firstPlayer;
  private Player secondPlayer;
  private GameBoard gameBoard;

  public Game(Player firstPlayer, Player secondPlayer, GameBoard gameBoard) {
    this.firstPlayer = firstPlayer;
    this.secondPlayer = secondPlayer;
    this.gameBoard = gameBoard;
    this.currentPlayer = firstPlayer;
  }

  public GameStatus playGame(String move) {
    if (!gameBoard.isValidMove(move, currentPlayer.getSign())) {
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


}
