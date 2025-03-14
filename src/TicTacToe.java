import java.util.Scanner;

/**
 * A simple Tic-Tac-Toe game implementation in Java.
 */
public class TicTacToe {
	private static char[][] board = new char[3][3];

	/**
	 * The main method to run the Tic-Tac-Toe game.
	 *
	 * @param args Command line arguments (not used).
	 */
	public static void main(String[] args) {
		boolean running = true; Scanner sc = new Scanner(System.in);
		int r; int c; int move = 0;
		while(running) {
			printBoard(board);
			if(move==9) {
				System.out.println("Game is draw!");
				break;
			}
			System.out.println("\n Please give your next move row and columns.");
			r = sc.nextInt(); c = sc.nextInt();
			while (!isValid(r,c)) {
				System.out.println("Invalid move!");
				r = sc.nextInt(); c = sc.nextInt();
			}
			board[r-1][c-1] = (move%2==0) ? 'X' : 'O'; move++;
			if (checkboard(board,r-1,c-1)) {
				System.out.printf("Player %s has won.",board[r-1][c-1]);
				running = false;
			}
		}
	}

	/**
	 * Checks if the current player has won the game.
	 *
	 * @param board The game board.
	 * @param row The row of the last move.
	 * @param col The column of the last move.
	 * @return True if the current player has won, false otherwise.
	 */
	public static boolean checkboard(char[][] board, int row, int col) {
		//if(board[row][0] == board[row][1] &&
		//	board[row][0] == board[row][2]) return true;
		//else if(board[0][col] == board[1][col] &&
		//		board[0][col] == board[2][col]) return true;
		//
		//// Check for middle square
		//if (board[1][1]!='\0'){
		//	char p = board[1][1];
		//	if(board[0][0] == board[2][2] && board[0][0] == p) return true;
		//	else if(board[0][2] == board[2][0] && board[0][2] == p) return true;
		//}
        //return false;

		char symbol = board[row][col];
		boolean win = true;

		for (int i = 0; i < 3; i++) {
			if (board[row][i] != symbol) {
				win = false; break;
			}
		} if(win){
			return true;
		}

		win = true;
		// for cols
		for (int i = 0; i < 3; i++) {
			if(board[i][col] != symbol){
				win = false; break;
			}
		} if(win) return true;

		if(row==col) {
			win = true;
			for (int i = 0; i < 3; i++) {
				if (board[i][i] != symbol){
					win = false; break;
				}
			}
		} if(win) return true;

		if (row + col == 2){
			win = true;
			for (int i = 0; i < 3; i++) {
				if(board[i][2-i] != symbol){
					win = false; break;
				}
			}
		} if(win) return true;

		return false;
    }

	/**
	 * Prints the current state of the game board.
	 *
	 * @param board The game board.
	 */
	public static void printBoard(char[][] board) {
		System.out.print(" |1|2|3\n-------\n");
		for (int i = 0; i < 3; i++) {
			System.out.printf("%d|%c|%c|%c\n",i+1,board[i][0],board[i][1],board[i][2]);
		}
	}

	/**
	 * Validates if the given row and column are within the valid range.
	 *
	 * @param row The row number.
	 * @param col The column number.
	 * @return True if the row and column are valid, false otherwise.
	 */
	public static boolean isValid(int row, int col) {
		if(col > 3 || row > 3 || row<1 || col<1) return false;
		else return board[row-1][col-1] == 0;
	}
}