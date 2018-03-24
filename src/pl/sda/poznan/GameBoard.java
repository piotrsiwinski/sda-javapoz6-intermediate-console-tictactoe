package pl.sda.poznan;

// klasa reprezentujaca plansze
public class GameBoard {

  private char[][] board = new char[3][3];

  /**
   * Wypisuje zawartosc planszy
   */
  public void print() {
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        System.out.print(board[i][j]);
        if (j < 2) {
          System.out.print(" | ");
        }
      }
      if (i != 2) {
        System.out.println("\n-------");
      }
    }
  }

  /**
   * Metoda ktora sprawdza czy na danej pozycji mozna postawic znak
   */
  public boolean isValidMove(String position, char playerSign) {
    int number = Integer.parseInt(position);
    int row = number / 3;
    int col = number % 3;
    return board[row][col] == 0;
  }

  public boolean add(String position, char playerSign) {
    int number = Integer.parseInt(position);
    int row = number / 3;
    int col = number % 3;
    board[row][col] = playerSign;
    return isWinningMove(playerSign);
  }

  public boolean isWinningMove(char playerSign) {
    return checkColumns(playerSign) || checkRows(playerSign) || chechDiagonals(playerSign);
  }

  private boolean checkRows(char playerSign) {
    return board[0][0] == playerSign && board[0][1] == playerSign && board[0][2] == playerSign ||
        board[1][0] == playerSign && board[1][1] == playerSign && board[1][2] == playerSign ||
        board[2][0] == playerSign && board[2][1] == playerSign && board[2][2] == playerSign;
  }

  private boolean checkColumns(char playerSign) {
    return board[0][0] == playerSign && board[1][0] == playerSign && board[2][0] == playerSign ||
        board[0][1] == playerSign && board[1][1] == playerSign && board[2][1] == playerSign ||
        board[0][2] == playerSign && board[1][2] == playerSign && board[2][2] == playerSign;
  }

  private boolean chechDiagonals(char playerSign) {
    return ((board[0][0] == board[1][1] && board[1][1] == board[2][2]) && board[0][0] == playerSign)
        ||
        ((board[0][2] == board[1][1] && board[1][1] == board[2][0]) && board[0][2] == playerSign);
  }

}
